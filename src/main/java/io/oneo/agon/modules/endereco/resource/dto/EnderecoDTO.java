package io.oneo.agon.modules.endereco.resource.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.oneo.agon.modules.cidade.support.dto.CidadeDTO;
import io.oneo.agon.modules.endereco.type.ComplementoLogradouroTipo;
import io.oneo.agon.modules.endereco.type.LogradouroTipo;
import io.oneo.agon.modules.endereco.type.MoradiaComplementoTipo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoDTO implements Serializable
{
    private static final long serialVersionUID = 603746338423548723L;

    private Long id;

    private CidadeDTO cidade;

    private LogradouroTipo logradouroTipo;

    private MoradiaComplementoTipo moradiaTipo;

    private ComplementoLogradouroTipo complementoTipo;

    private int numero;

    private String bairro;

    private String setor;

    private String cep;

    private String referencia;

    private String bloco;

    private int andar;

    private int aptoNumero;
}