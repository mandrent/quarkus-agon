package io.oneo.agon.modules.geral.endereco.support.dto;

import io.oneo.agon.modules.geral.cidade.support.dto.CidadeDTO;
import io.oneo.agon.modules.geral.endereco.type.LogradouroTipo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class EnderecoDTO implements Serializable
{
    private static final long serialVersionUID = 603746338423548723L;

    private LogradouroTipo logradouro;

    private int numero;

    private EnderecoComplementoDTO complemento;

    private String bairro;

    private String setor;

    private String cep;

    private CidadeDTO cidade;
}