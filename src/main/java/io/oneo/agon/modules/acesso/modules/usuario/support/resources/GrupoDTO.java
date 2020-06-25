package io.oneo.agon.modules.acesso.modules.usuario.support.resources;

import io.oneo.agon.modules.acesso.modules.usuario.type.GrupoTipo;
import io.oneo.agon.modules.acesso.modules.usuario.type.NivelTipo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter @Setter
public class GrupoDTO
{
    public GrupoTipo tipo;

    public NivelTipo nivel;

    public Set<UsuarioDTO> usuarios;

    public Integer operacao;

    public LocalDateTime inclusao;
}