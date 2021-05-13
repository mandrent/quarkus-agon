package io.oneo.agon.modules.usuario.service;

import io.oneo.agon.modules.usuario.exception.UsuarioServiceException;
import io.oneo.agon.modules.usuario.model.Usuario;
import io.oneo.agon.modules.usuario.type.GrupoTipo;
import io.oneo.agon.modules.usuario.type.StatusUsuarioTipo;

import java.util.Optional;

public interface IUsuarioService
{
    GrupoTipo validarGrupo(Integer grupoValor);

    StatusUsuarioTipo validarStatus(Integer statusValor);

    Optional<Usuario> findByLogin(String login) throws UsuarioServiceException;

    Optional<Usuario> findByEmail(String email) throws UsuarioServiceException;
}