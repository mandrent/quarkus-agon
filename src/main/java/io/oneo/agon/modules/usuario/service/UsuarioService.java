package io.oneo.agon.modules.usuario.service;

import io.oneo.agon.infra.service.BaseService;
import io.oneo.agon.modules.usuario.model.Usuario;
import io.oneo.agon.modules.usuario.repository.UsuarioRepository;
import io.oneo.agon.modules.usuario.type.GrupoTipo;
import io.oneo.agon.modules.usuario.type.StatusUsuarioTipo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UsuarioService extends BaseService<Usuario, Long> implements IUsuarioService
{
    @Inject UsuarioRepository repo;

    public Optional<Usuario> findByLogin(String login)
    {
        Optional<Usuario> usuario = this.repo.buscarPorLogin(login);
        if (!usuario.isPresent())
        {
            return Optional.empty();
        }
        return usuario;
    }
}