package io.oneo.agon.modules.usuario.repository;

import io.oneo.agon.modules.usuario.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario>
{
    public Optional<Usuario> findByLogin(String login)
    {
        return this.find("login", login).firstResultOptional();
    }

    public Optional<Usuario> findByEmail(String email)
    {
        return this.find("email", email).firstResultOptional();
    }


}