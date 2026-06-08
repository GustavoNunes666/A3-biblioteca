package com.biblioteca.demo.repository;

import com.biblioteca.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}