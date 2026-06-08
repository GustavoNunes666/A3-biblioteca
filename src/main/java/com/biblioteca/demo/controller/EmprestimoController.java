package com.biblioteca.demo.controller;

import com.biblioteca.demo.model.Emprestimo;
import com.biblioteca.demo.service.EmprestimoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping
    public ResponseEntity<Emprestimo> realizarEmprestimo(@RequestParam Long livroId,
                                                          @RequestParam Long usuarioId) {
        return ResponseEntity.ok(emprestimoService.realizarEmprestimo(livroId, usuarioId));
    }

    @PutMapping("/{id}/devolver")
    public ResponseEntity<Emprestimo> devolver(@PathVariable Long id) {
        return ResponseEntity.ok(emprestimoService.realizarDevolucao(id));
    }

    @GetMapping("/abertos")
    public ResponseEntity<List<Emprestimo>> listarAbertos() {
        return ResponseEntity.ok(emprestimoService.listarAbertos());
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Emprestimo>> listarPorUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(emprestimoService.listarPorUsuario(id));
    }
}