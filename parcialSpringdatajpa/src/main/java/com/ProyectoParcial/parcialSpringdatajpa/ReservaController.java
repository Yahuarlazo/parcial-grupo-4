package com.ProyectoParcial.parcialSpringdatajpa;


import com.ProyectoParcial.parcialSpringdatajpa.entidades.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")

public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping
    public List<Reserva> obtenerReservas(){return reservaRepository.findAll();}

    @GetMapping("/{id}")
    public Reserva obtenerReserva(@PathVariable int id) {
        return reservaRepository.findById((long) id).orElse(null);
    }

    @PostMapping
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @PutMapping("/{id}")
    public Reserva actualizarReserva(@PathVariable int id, @RequestBody Reserva reservaActualizada) {
        Reserva reservaExistente = reservaRepository.findById((long) id).orElse(null);
        if (reservaExistente != null) {
            reservaExistente.setId_inmueble(reservaActualizada.getId_inmueble());
            reservaExistente.setId_usuario(reservaActualizada.getId_usuario());
            reservaExistente.setEstadoReserva(reservaActualizada.getEstadoReserva());
            reservaExistente.setFechaReserva(reservaActualizada.getFechaReserva());
            reservaExistente.setFechaIngreso(reservaActualizada.getFechaIngreso());
            reservaExistente.setFechaSalida(reservaActualizada.getFechaSalida());
            reservaExistente.setPrecioTotal(reservaActualizada.getPrecioTotal());
            return reservaRepository.save(reservaExistente);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarReserva(@PathVariable int id) {
        reservaRepository.deleteById((long) id);
    }
}