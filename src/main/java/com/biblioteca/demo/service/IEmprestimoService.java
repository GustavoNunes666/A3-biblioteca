package com.biblioteca.demo.service;

import com.biblioteca.demo.model.Emprestimo;
import java.util.List;

public interface IEmprestimoService {
    Emprestimo realizarEmprestimo(Long livroId, Long usuarioId);
    Emprestimo realizarDevolucao(Long emprestimoId);
    List<Emprestimo> listarAbertos();
    List<Emprestimo> listarPorUsuario(Long usuarioId);
}