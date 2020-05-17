package io.oneo.agon.modules.acesso.modules.usuario.repository;

import io.oneo.agon.modules.acesso.modules.grupo.model.Grupo;
import io.oneo.agon.modules.acesso.modules.usuario.model.Usuario;
import io.oneo.agon.modules.acesso.modules.usuario.type.StatusUsuarioTipo;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class UsuarioRepository implements PanacheRepositoryBase<Usuario, Long>
{
    public Usuario buscarPorLogin(String login)
    {
        return this.find("login", login).firstResult();
    }

    public Usuario buscarPorEmail(String email)
    {
        return this.find("email", email).firstResult();
    }

    public List<Usuario> listarPorGrupo(Grupo grupo)
    {
        return this.list("grupo", grupo);
    }

    public List<Usuario> listarPorStatus(StatusUsuarioTipo status) { return this.list("status", status); }



}