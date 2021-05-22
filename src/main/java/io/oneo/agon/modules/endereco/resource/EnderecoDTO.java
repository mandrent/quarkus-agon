package io.oneo.agon.modules.endereco.resource;

import io.oneo.agon.modules.cidade.resource.CidadeDTO;
import io.oneo.agon.modules.endereco.type.ComplementoTipo;
import io.oneo.agon.modules.endereco.type.LogradouroTipo;
import io.oneo.agon.modules.endereco.type.MoradiaTipo;

import java.io.Serializable;

public class EnderecoDTO implements Serializable
{
    private static final long serialVersionUID = 603746338423548723L;

    public Long id;

    public CidadeDTO cidade;

    public LogradouroTipo logradouroTipo;

    public MoradiaTipo moradiaTipo;

    public ComplementoTipo complementoTipo;

    public int numero;

    public String bairro;

    public String setor;

    public String cep;

    public String referencia;

    public String bloco;

    public int andar;

    public int aptoNumero;
}