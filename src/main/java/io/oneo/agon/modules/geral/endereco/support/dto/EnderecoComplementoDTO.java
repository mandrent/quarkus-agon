package io.oneo.agon.modules.geral.endereco.support.dto;

import io.oneo.agon.modules.geral.endereco.type.LocalComplementoTipo;
import io.oneo.agon.modules.geral.endereco.type.LogradouroComplementoTipo;
import io.oneo.agon.modules.geral.endereco.type.MoradiaComplementoTipo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter 
public class EnderecoComplementoDTO implements Serializable
{
    private static final long serialVersionUID = -5161833480284702596L;

    private EnderecoDTO endereco;

    private LocalComplementoTipo localidade;

    private LogradouroComplementoTipo logradouro;

    private MoradiaComplementoTipo moradia;

    private String referencia;

    private String bloco;

    private int andar;

    private int numero;
}
