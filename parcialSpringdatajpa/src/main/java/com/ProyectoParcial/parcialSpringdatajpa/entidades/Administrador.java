package com.ProyectoParcial.parcialSpringdatajpa.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Administrador")

public class Administrador {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_administrador;
    private String nombres;
    private String apellidos;
    private int edad;
    private String TipoDocumento;
    private String NumDocumento;
    private String Celular;
    private String correo;
    private int id_perfil;

}
