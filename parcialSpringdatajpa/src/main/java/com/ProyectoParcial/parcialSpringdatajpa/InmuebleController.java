package com.ProyectoParcial.parcialSpringdatajpa;

import com.ProyectoParcial.parcialSpringdatajpa.entidades.Inmueble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/inmuebles")
public class InmuebleController {

    @Autowired
    private InmuebleRepository inmuebleRepository;

    @GetMapping("")
    public List<Inmueble> getAllInmuebles() {
        return inmuebleRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inmueble> getInmuebleById(@PathVariable int id) {
        Optional<Inmueble> inmuebleOptional = inmuebleRepository.findById((long) id);
        if (inmuebleOptional.isPresent()) {
            return ResponseEntity.ok(inmuebleOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Inmueble> createInmueble(@RequestBody Inmueble inmueble) {
        Inmueble createdInmueble = inmuebleRepository.save(inmueble);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInmueble);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inmueble> updateInmueble(@PathVariable int id, @RequestBody Inmueble inmueble) {
        Optional<Inmueble> inmuebleOptional = inmuebleRepository.findById((long) id);
        if (inmuebleOptional.isPresent()) {
            inmueble.setId_inmueble(id);
            Inmueble updatedInmueble = inmuebleRepository.save(inmueble);
            return ResponseEntity.ok(updatedInmueble);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInmueble(@PathVariable int id) {
        Optional<Inmueble> inmuebleOptional = inmuebleRepository.findById((long) id);
        if (inmuebleOptional.isPresent()) {
            inmuebleRepository.deleteById((long) id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
