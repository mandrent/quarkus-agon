package io.oneo.agon.modules.usuario.service;

import io.oneo.agon.modules.common.service.BaseService;
import io.oneo.agon.modules.usuario.model.Usuario;
import io.oneo.agon.modules.usuario.repository.UsuarioRepository;
import io.oneo.agon.modules.usuario.type.GrupoTipo;
import io.oneo.agon.modules.usuario.type.StatusUsuarioTipo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UsuarioService extends BaseService<Usuario, Long> implements IUsuarioService
{
    @Inject UsuarioRepository repo;

    public Usuario buscarPorLogin(String login) { return this.repo.buscarPorLogin(login); }

    public Usuario buscarPorEmail(String email) { return this.repo.buscarPorEmail(email); }

    public List<Usuario> listarPorGrupo(GrupoTipo grupo) { return this.repo.listarPorGrupo(grupo); }

    public List<Usuario> listarPorStatus(StatusUsuarioTipo status) { return this.repo.listarPorStatus(status); }


}