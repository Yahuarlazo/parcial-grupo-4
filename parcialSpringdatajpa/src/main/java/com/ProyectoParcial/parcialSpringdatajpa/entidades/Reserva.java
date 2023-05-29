package com.ProyectoParcial.parcialSpringdatajpa.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
@Entity

public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_reserva;
    private int id_inmueble;
    private int id_usuario;
    private Date EstadoReserva;
    private Date FechaReserva;
    private Date FechaIngreso;
    private int FechaSalida;
    private BigDecimal PrecioTotal;
}
