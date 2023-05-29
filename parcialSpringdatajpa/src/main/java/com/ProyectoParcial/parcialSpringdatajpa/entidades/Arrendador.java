package com.ProyectoParcial.parcialSpringdatajpa.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Arrendador")

public class Arrendador {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_arrendador;
    private String nombres;
    private String apellidos;
    private int edad;
    private String TipoDocumento;
    private String NumDocumento;
    private String Celular;
    private String correo;
    private int id_perfil;
}
