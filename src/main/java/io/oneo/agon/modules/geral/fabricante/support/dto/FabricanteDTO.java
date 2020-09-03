package io.oneo.agon.modules.geral.fabricante.support.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class FabricanteDTO implements Serializable
{
    private static final long serialVersionUID = -6456305847314971431L;

    private String modelo;

    private String tipo;

    private String descricao;
}