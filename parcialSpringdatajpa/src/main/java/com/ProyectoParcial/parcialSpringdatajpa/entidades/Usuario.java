package com.ProyectoParcial.parcialSpringdatajpa.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity

public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int id_usuario;
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String NumDocumento;
    private Date fechaNacimiento;
    private int id_perfil;

}
