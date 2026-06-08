package com.biblioteca.demo;

import com.biblioteca.demo.model.Livro;
import com.biblioteca.demo.model.Usuario;
import com.biblioteca.demo.service.EmprestimoService;
import com.biblioteca.demo.service.LivroService;
import com.biblioteca.demo.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final LivroService livroService;
    private final UsuarioService usuarioService;
    private final EmprestimoService emprestimoService;

    public DataLoader(LivroService livroService, UsuarioService usuarioService, EmprestimoService emprestimoService) {
        this.livroService = livroService;
        this.usuarioService = usuarioService;
        this.emprestimoService = emprestimoService;
    }

    @Override
    public void run(String... args) {

        // Cadastrar livros
        Livro l1 = new Livro();
        l1.setTitulo("Dom Casmurro");
        l1.setAutor("Machado de Assis");
        l1.setIsbn("978-8525406958");
        livroService.salvar(l1);

        Livro l2 = new Livro();
        l2.setTitulo("O Cortiço");
        l2.setAutor("Aluísio Azevedo");
        l2.setIsbn("978-8572328876");
        livroService.salvar(l2);

        Livro l3 = new Livro();
        l3.setTitulo("A Hora da Estrela");
        l3.setAutor("Clarice Lispector");
        l3.setIsbn("978-8520927302");
        livroService.salvar(l3);

        // Cadastrar usuários
        Usuario u1 = new Usuario();
        u1.setNome("Gustavo Nunes");
        u1.setEmail("gustavo@email.com");
        usuarioService.salvar(u1);

        Usuario u2 = new Usuario();
        u2.setNome("Maria Silva");
        u2.setEmail("maria@email.com");
        usuarioService.salvar(u2);

        // Realizar um empréstimo já de início
        emprestimoService.realizarEmprestimo(1L, 1L);
    }
}