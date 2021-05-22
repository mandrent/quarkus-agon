package io.oneo.agon.modules.empresa.modules.cargo.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CargoDTO implements Serializable
{
    private static final long serialVersionUID = 6758383658947723548L;

    private Long id;

    private String nome;

    private String funcao;

    private String setor;

    private String referencia;

    private String descricao;
}