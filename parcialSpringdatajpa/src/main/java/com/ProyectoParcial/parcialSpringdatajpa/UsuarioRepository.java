package com.ProyectoParcial.parcialSpringdatajpa;

import com.ProyectoParcial.parcialSpringdatajpa.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
