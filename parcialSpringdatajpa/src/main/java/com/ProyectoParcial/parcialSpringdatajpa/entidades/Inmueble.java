package com.ProyectoParcial.parcialSpringdatajpa.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name="Inmueble")

public class Inmueble {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_inmueble;
    private String NombreInmueble;
    private int id_arrendador;
    private String EstadoInmueble;
    private String Condicion;
    private BigDecimal PrecioNoche; // Utilizar BigDecimal en lugar de Double
    private int HistorialDeArriendos;
    private String Espacios;
}
