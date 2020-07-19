package io.oneo.agon.modules.usuario.support.dto;

import io.oneo.agon.modules.usuario.type.StatusUsuarioTipo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class UsuarioDTO
{
    private long id;

    private String login;

    private String senha;

    private String email;

    private GrupoDTO grupo;

    private StatusUsuarioTipo status;

    private LocalDateTime criacao;

    private LocalDateTime acessData;

    private LocalDateTime update;
}