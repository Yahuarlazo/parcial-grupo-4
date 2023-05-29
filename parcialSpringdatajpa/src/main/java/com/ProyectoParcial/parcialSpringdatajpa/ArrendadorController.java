package com.ProyectoParcial.parcialSpringdatajpa;

import com.ProyectoParcial.parcialSpringdatajpa.entidades.Arrendador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/arrendadores")
public class ArrendadorController {

    @Autowired
    private ArrendadorRepository arrendadorRepository;

    @GetMapping("")
    public List<Arrendador> getAllArrendadores() {
        return arrendadorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arrendador> getArrendadorById(@PathVariable int id) {
        Optional<Arrendador> arrendadorOptional = arrendadorRepository.findById((long) id);
        if (arrendadorOptional.isPresent()) {
            return ResponseEntity.ok(arrendadorOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
//test
    @PostMapping("")
    public ResponseEntity<Arrendador> createArrendador(@RequestBody Arrendador arrendador) {
        Arrendador createdArrendador = arrendadorRepository.save(arrendador);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdArrendador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Arrendador> updateArrendador(@PathVariable int id, @RequestBody Arrendador arrendador) {
        Optional<Arrendador> arrendadorOptional = arrendadorRepository.findById((long) id);
        if (arrendadorOptional.isPresent()) {
            arrendador.setId_arrendador(id);
            Arrendador updatedArrendador = arrendadorRepository.save(arrendador);
            return ResponseEntity.ok(updatedArrendador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArrendador(@PathVariable int id) {
        Optional<Arrendador> arrendadorOptional = arrendadorRepository.findById((long) id);
        if (arrendadorOptional.isPresent()) {
            arrendadorRepository.deleteById((long) id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
