package com.biblioteca.demo.decorator;

import com.biblioteca.demo.model.Emprestimo;
import com.biblioteca.demo.service.EmprestimoService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmprestimoServiceDecorator {

    private final EmprestimoService emprestimoService;

    public EmprestimoServiceDecorator(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    public Emprestimo realizarEmprestimo(Long livroId, Long usuarioId) {
        System.out.println("[LOG] Iniciando empréstimo - livroId: " + livroId + ", usuarioId: " + usuarioId);
        Emprestimo emprestimo = emprestimoService.realizarEmprestimo(livroId, usuarioId);
        System.out.println("[LOG] Empréstimo realizado com sucesso - id: " + emprestimo.getId());
        return emprestimo;
    }

    public Emprestimo realizarDevolucao(Long emprestimoId) {
        System.out.println("[LOG] Iniciando devolução - emprestimoId: " + emprestimoId);
        Emprestimo emprestimo = emprestimoService.realizarDevolucao(emprestimoId);
        System.out.println("[LOG] Devolução realizada com sucesso - livro disponível novamente");
        return emprestimo;
    }

    public List<Emprestimo> listarAbertos() {
        System.out.println("[LOG] Consultando empréstimos em aberto");
        return emprestimoService.listarAbertos();
    }
}