package com.ProyectoParcial.parcialSpringdatajpa;

import com.ProyectoParcial.parcialSpringdatajpa.entidades.Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorRepository administradorRepository;

    @GetMapping("")
    public List<Administrador> getAllAdministradores() {
        return administradorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrador> getAdministradorById(@PathVariable int id) {
        Optional<Administrador> administradorOptional = administradorRepository.findById((long) id);
        if (administradorOptional.isPresent()) {
            return ResponseEntity.ok(administradorOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Administrador> createAdministrador(@RequestBody Administrador administrador) {
        Administrador createdAdministrador = administradorRepository.save(administrador);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAdministrador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrador> updateAdministrador(@PathVariable int id, @RequestBody Administrador administrador) {
        Optional<Administrador> administradorOptional = administradorRepository.findById((long) id);
        if (administradorOptional.isPresent()) {
            administrador.setId_administrador(id);
            Administrador updatedAdministrador = administradorRepository.save(administrador);
            return ResponseEntity.ok(updatedAdministrador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrador(@PathVariable int id) {
        Optional<Administrador> administradorOptional = administradorRepository.findById((long) id);
        if (administradorOptional.isPresent()) {
            administradorRepository.deleteById((long) id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
