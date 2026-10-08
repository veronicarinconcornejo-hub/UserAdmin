package com.Alta.usuarios.service;

import com.Alta.usuarios.model.EstadoUsuario;
import com.Alta.usuarios.model.Usuarios;
import com.Alta.usuarios.repository.IGenericRepo;
import com.Alta.usuarios.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService extends CrudImpl<Usuarios, Long> {

    private final UsuarioRepository repo;

    @Override
    protected IGenericRepo<Usuarios, Long> getRepo() {
        return repo;
    }

    public Usuarios cambiarStatus(Long id, EstadoUsuario status) throws Exception {
        Usuarios usuario = readById(id);
        usuario.setStatus(status);
        return repo.save(usuario);
    }
}