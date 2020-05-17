package io.oneo.agon.modules.acesso.modules.usuario.service;

import io.oneo.agon.infra.service.BaseService;
import io.oneo.agon.modules.acesso.modules.grupo.model.Grupo;
import io.oneo.agon.modules.acesso.modules.usuario.model.Usuario;
import io.oneo.agon.modules.acesso.modules.usuario.repository.UsuarioRepository;
import io.oneo.agon.modules.acesso.modules.usuario.type.StatusUsuarioTipo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;


@ApplicationScoped
public class UsuarioService extends BaseService<Usuario, Long> implements IUsuarioService
{
    @Inject private UsuarioRepository repo;

    public Usuario buscarPorLogin(String login) { return this.repo.buscarPorLogin(login); }

    public Usuario buscarPorEmail(String email) { return this.repo.buscarPorEmail(email); }

    public List<Usuario> listarPorGrupo(Grupo grupo) { return this.repo.listarPorGrupo(grupo); }

    public List<Usuario> listarPorStatus(StatusUsuarioTipo status) { return this.repo.listarPorStatus(status); }


}