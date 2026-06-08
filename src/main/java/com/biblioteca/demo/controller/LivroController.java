package com.biblioteca.demo.controller;

import com.biblioteca.demo.model.Livro;
import com.biblioteca.demo.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro) {
        return ResponseEntity.ok(livroService.salvar(livro));
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        return ResponseEntity.ok(livroService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.buscarPorId(id));
    }
}