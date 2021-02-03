package io.oneo.agon.modules.geral.endereco.support.dto;

import io.oneo.agon.modules.geral.cidade.support.dto.CidadeDTO;
import io.oneo.agon.modules.geral.endereco.type.LogradouroComplementoTipo;
import io.oneo.agon.modules.geral.endereco.type.LogradouroTipo;
import io.oneo.agon.modules.geral.endereco.type.MoradiaComplementoTipo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

//@Getter
//@Setter
public class EnderecoDTO implements Serializable
{
    private static final long serialVersionUID = 603746338423548723L;

    public Long id;

    public CidadeDTO cidade;

    public LogradouroTipo logradouroTipo;

    public LogradouroComplementoTipo complementoTipo;

    public int numero;

    public String bairro;

    public String setor;

    public String cep;

    public MoradiaComplementoTipo moradiaTipo;

    public String referencia;

    public String bloco;

    public int andar;

    public int aptoNumero;
}