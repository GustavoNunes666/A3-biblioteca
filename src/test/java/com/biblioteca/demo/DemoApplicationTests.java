package com.biblioteca.demo;

import com.biblioteca.demo.model.Livro;
import com.biblioteca.demo.model.Usuario;
import com.biblioteca.demo.model.Emprestimo;
import com.biblioteca.demo.repository.EmprestimoRepository;
import com.biblioteca.demo.repository.LivroRepository;
import com.biblioteca.demo.repository.UsuarioRepository;
import com.biblioteca.demo.service.EmprestimoService;
import com.biblioteca.demo.service.LivroService;
import com.biblioteca.demo.service.UsuarioService;
import com.biblioteca.demo.strategy.PrazoNormal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DemoApplicationTests {

    @Mock
    private LivroRepository livroRepository;
    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private EmprestimoRepository emprestimoRepository;

    @InjectMocks
    private LivroService livroService;
    @InjectMocks
    private UsuarioService usuarioService;

    private EmprestimoService emprestimoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        PrazoNormal prazoNormal = new PrazoNormal();
        emprestimoService = new EmprestimoService(emprestimoRepository, livroService, usuarioService, prazoNormal);
    }

    @Test
    void deveSalvarLivro() {
        Livro livro = new Livro();
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");

        when(livroRepository.save(livro)).thenReturn(livro);

        Livro salvo = livroService.salvar(livro);
        assertEquals("Dom Casmurro", salvo.getTitulo());
    }

    @Test
    void deveSalvarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome("Gustavo");
        usuario.setEmail("gustavo@email.com");

        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario salvo = usuarioService.salvar(usuario);
        assertEquals("Gustavo", salvo.getNome());
    }

    @Test
    void deveRealizarEmprestimo() {
        Livro livro = new Livro();
        livro.setId(1L);
        livro.setDisponivel(true);

        Usuario usuario = new Usuario();
        usuario.setId(1L);

        when(livroRepository.findById(1L)).thenReturn(Optional.of(livro));
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        when(livroRepository.save(livro)).thenReturn(livro);
        when(emprestimoRepository.save(any(Emprestimo.class))).thenAnswer(i -> i.getArgument(0));

        Emprestimo emprestimo = emprestimoService.realizarEmprestimo(1L, 1L);

        assertFalse(livro.isDisponivel());
        assertNotNull(emprestimo.getDataEmprestimo());
        assertFalse(emprestimo.isDevolvido());
    }

    @Test
    void deveLancarExcecaoLivroIndisponivel() {
        Livro livro = new Livro();
        livro.setId(1L);
        livro.setDisponivel(false);

        Usuario usuario = new Usuario();
        usuario.setId(1L);

        when(livroRepository.findById(1L)).thenReturn(Optional.of(livro));
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        assertThrows(RuntimeException.class, () -> {
            emprestimoService.realizarEmprestimo(1L, 1L);
        });
    }
}