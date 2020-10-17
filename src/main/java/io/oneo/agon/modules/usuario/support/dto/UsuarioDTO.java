package io.oneo.agon.modules.usuario.support.dto;

import io.oneo.agon.modules.usuario.type.GrupoTipo;
import io.oneo.agon.modules.usuario.type.StatusUsuarioTipo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
public class UsuarioDTO implements Serializable
{
    private static final long serialVersionUID = 3457897005042647280L;

    private Long id;

    private String login;

    private String senha;

    private String email;

    private GrupoTipo grupo;

    private StatusUsuarioTipo status;

    private LocalDateTime criacao;

    private LocalDateTime acessData;

    private LocalDateTime update;
}