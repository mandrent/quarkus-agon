package io.oneo.agon.modules.geral.estado.support.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EstadoDTO implements Serializable
{
    private static final long serialVersionUID = -707397699058100216L;

    private String nome;

    private String sigla;

    private String regiao;
}
