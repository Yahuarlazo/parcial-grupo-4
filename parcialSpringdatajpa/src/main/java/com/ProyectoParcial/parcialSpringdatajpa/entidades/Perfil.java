package com.ProyectoParcial.parcialSpringdatajpa.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_perfil;
    private String clave;
    private String nombreUsuario;
    private String correo;
}
