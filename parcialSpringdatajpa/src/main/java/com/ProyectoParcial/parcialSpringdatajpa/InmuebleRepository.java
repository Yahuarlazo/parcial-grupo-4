package com.ProyectoParcial.parcialSpringdatajpa;

import com.ProyectoParcial.parcialSpringdatajpa.entidades.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {
}