package com.biblioteca.demo.repository;

import com.biblioteca.demo.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    List<Emprestimo> findByDevolvido(boolean devolvido);
    List<Emprestimo> findByUsuarioId(Long usuarioId);
}