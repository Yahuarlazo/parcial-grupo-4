package com.ProyectoParcial.parcialSpringdatajpa;

import com.ProyectoParcial.parcialSpringdatajpa.entidades.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository <Perfil,Long> {
}
