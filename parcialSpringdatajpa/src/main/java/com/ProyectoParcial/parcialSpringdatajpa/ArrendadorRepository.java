package com.ProyectoParcial.parcialSpringdatajpa;

import com.ProyectoParcial.parcialSpringdatajpa.entidades.Arrendador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrendadorRepository extends JpaRepository<Arrendador, Long> {
}