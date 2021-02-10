package io.oneo.agon.modules.telefone.resource.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.oneo.agon.modules.telefone.type.TelefoneTipo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelefoneDTO implements Serializable
{
    private static final long serialVersionUID = -782188649105570983L;

    private Long id;

    private String ddd;

    private String numero;

    private TelefoneTipo tipo;
}