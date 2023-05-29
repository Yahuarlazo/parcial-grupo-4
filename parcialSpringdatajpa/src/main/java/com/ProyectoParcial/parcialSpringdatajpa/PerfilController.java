package com.ProyectoParcial.parcialSpringdatajpa;

import com.ProyectoParcial.parcialSpringdatajpa.entidades.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/perfiles")
public class PerfilController {

    @Autowired
    private PerfilRepository perfilRepository;

    @GetMapping
    public List<Perfil> obtenerPerfiles() {
        return perfilRepository.findAll();
    }

    @GetMapping("/{id}")
    public Perfil obtenerPerfil(@PathVariable int id) {
        return perfilRepository.findById((long) id).orElse(null);
    }

    @PostMapping
    public Perfil crearPerfil(@RequestBody Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @PutMapping("/{id}")
    public Perfil actualizarPerfil(@PathVariable int id, @RequestBody Perfil perfilActualizado) {
        Perfil perfilExistente = perfilRepository.findById((long) id).orElse(null);
        if (perfilExistente != null) {
            perfilExistente.setClave(perfilActualizado.getClave());
            perfilExistente.setNombreUsuario(perfilActualizado.getNombreUsuario());
            perfilExistente.setCorreo(perfilActualizado.getCorreo());
            return perfilRepository.save(perfilExistente);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarPerfil(@PathVariable int id) {
        perfilRepository.deleteById((long) id);
    }
}