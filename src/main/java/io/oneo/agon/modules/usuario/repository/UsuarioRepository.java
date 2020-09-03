package io.oneo.agon.modules.usuario.repository;

import io.oneo.agon.modules.usuario.model.Usuario;
import io.oneo.agon.modules.usuario.type.GrupoTipo;
import io.oneo.agon.modules.usuario.type.StatusUsuarioTipo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario>
{
    public Usuario buscarPorLogin(String login)
    {
        return this.find("login", login).firstResult();
    }

    public Usuario buscarPorEmail(String email)
    {
        return this.find("email", email).firstResult();
    }

    public List<Usuario> listarPorGrupo(GrupoTipo grupo)
    {
        return this.list("grupo", grupo);
    }

    public List<Usuario> listarPorStatus(StatusUsuarioTipo status) { return this.list("status", status); }



}