package com.Alta.usuarios.controller;

import com.Alta.usuarios.model.EstadoUsuario;
import com.Alta.usuarios.model.Usuarios;
import com.Alta.usuarios.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UserService service;

    // Dar de alta
    @PostMapping
    public ResponseEntity<Usuarios> save(@RequestBody Usuarios usuario) throws Exception {
        return new ResponseEntity<>(service.save(usuario), HttpStatus.CREATED);
    }

    // Consultar todos
    @GetMapping
    public ResponseEntity<List<Usuarios>> readAll() throws Exception {
        return ResponseEntity.ok(service.readAll());
    }

    // Consultar uno
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> readById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(service.readById(id));
    }

    // Modificar
    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> update(@PathVariable Long id,
                                           @RequestBody Usuarios usuario) throws Exception {
        usuario.setId(id);
        return ResponseEntity.ok(service.update(usuario, id));
    }

    // Habilitar
    @PatchMapping("/{id}/habilitar")
    public ResponseEntity<Usuarios> habilitar(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(service.cambiarStatus(id, EstadoUsuario.HABILITADO));
    }

    // Deshabilitar
    @PatchMapping("/{id}/deshabilitar")
    public ResponseEntity<Usuarios> deshabilitar(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(service.cambiarStatus(id, EstadoUsuario.DESHABILITADO));
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
