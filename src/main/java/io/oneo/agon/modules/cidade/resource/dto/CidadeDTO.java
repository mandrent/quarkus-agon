package io.oneo.agon.modules.cidade.resource.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.oneo.agon.modules.estado.resource.dto.EstadoDTO;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CidadeDTO implements Serializable
{
    private static final long serialVersionUID = -1349343623571914416L;

    public Long id;

    public String nome;

    public String codigo;

    public EstadoDTO estado;
}