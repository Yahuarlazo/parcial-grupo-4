package com.ProyectoParcial.parcialSpringdatajpa;

import com.ProyectoParcial.parcialSpringdatajpa.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository <Reserva,Long> {
}
