package io.oneo.agon.modules.usuario.service;

import io.oneo.agon.modules.usuario.model.Usuario;

import java.util.Optional;

public interface IUsuarioService
{
    Optional<Usuario> findByLogin(String login);

    Optional<Usuario> findByEmail(String email);
}