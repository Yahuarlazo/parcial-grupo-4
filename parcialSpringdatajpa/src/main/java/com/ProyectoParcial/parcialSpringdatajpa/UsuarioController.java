package com.ProyectoParcial.parcialSpringdatajpa;

import com.ProyectoParcial.parcialSpringdatajpa.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> obtenerUsuarios(){return usuarioRepository.findAll();}

    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable int id) {
        return usuarioRepository.findById((long) id).orElse(null);
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuarioActualizado) {
        Usuario usuarioExistente = usuarioRepository.findById((long) id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNombres(usuarioActualizado.getNombres());
            usuarioExistente.setApellidos(usuarioActualizado.getApellidos());
            usuarioExistente.setTipoDocumento(usuarioActualizado.getTipoDocumento());
            usuarioExistente.setNumDocumento(usuarioActualizado.getNumDocumento());
            usuarioExistente.setFechaNacimiento(usuarioActualizado.getFechaNacimiento());
            usuarioExistente.setId_perfil(usuarioActualizado.getId_perfil());
            return usuarioRepository.save(usuarioExistente);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        usuarioRepository.deleteById((long) id);
    }
}