package io.oneo.agon.modules.usuario.repository;

import io.oneo.agon.modules.usuario.model.Usuario;
import io.oneo.agon.modules.usuario.type.GrupoTipo;
import io.oneo.agon.modules.usuario.type.StatusUsuarioTipo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario>
{
    public Optional<Usuario> buscarPorLogin(String login)
    {
        Usuario usuario = this.find("login", login).firstResult();
        return Optional.of(usuario);
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