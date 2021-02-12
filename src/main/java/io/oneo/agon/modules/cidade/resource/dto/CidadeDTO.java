package io.oneo.agon.modules.cidade.resource.dto;

import io.oneo.agon.modules.estado.resource.dto.EstadoDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class CidadeDTO implements Serializable
{
    private static final long serialVersionUID = -1349343623571914416L;

    private String nome;

    private String codigo;

    private EstadoDTO estado;
}