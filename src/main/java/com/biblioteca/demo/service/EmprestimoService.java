package com.biblioteca.demo.service;

import com.biblioteca.demo.model.Emprestimo;
import com.biblioteca.demo.model.Livro;
import com.biblioteca.demo.model.Usuario;
import com.biblioteca.demo.repository.EmprestimoRepository;
import com.biblioteca.demo.strategy.PrazoDevolucaoStrategy;
import com.biblioteca.demo.strategy.PrazoNormal;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroService livroService;
    private final UsuarioService usuarioService;
    private PrazoDevolucaoStrategy prazoStrategy;

    public EmprestimoService(EmprestimoRepository emprestimoRepository,
                              LivroService livroService,
                              UsuarioService usuarioService,
                              PrazoNormal prazoNormal) {
        this.emprestimoRepository = emprestimoRepository;
        this.livroService = livroService;
        this.usuarioService = usuarioService;
        this.prazoStrategy = prazoNormal;
    }

    public void setPrazoStrategy(PrazoDevolucaoStrategy prazoStrategy) {
        this.prazoStrategy = prazoStrategy;
    }

    public Emprestimo realizarEmprestimo(Long livroId, Long usuarioId) {
        Livro livro = livroService.buscarPorId(livroId);
        Usuario usuario = usuarioService.buscarPorId(usuarioId);

        if (!livro.isDisponivel()) {
            throw new RuntimeException("Livro não está disponível");
        }

        livro.setDisponivel(false);
        livroService.salvar(livro);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(livro);
        emprestimo.setUsuario(usuario);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucao(LocalDate.now().plusDays(prazoStrategy.getPrazoEmDias()));

        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo realizarDevolucao(Long emprestimoId) {
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        emprestimo.setDevolvido(true);
        emprestimo.getLivro().setDisponivel(true);
        livroService.salvar(emprestimo.getLivro());

        return emprestimoRepository.save(emprestimo);
    }

    public List<Emprestimo> listarAbertos() {
        return emprestimoRepository.findByDevolvido(false);
    }

    public List<Emprestimo> listarPorUsuario(Long usuarioId) {
        return emprestimoRepository.findByUsuarioId(usuarioId);
    }
}