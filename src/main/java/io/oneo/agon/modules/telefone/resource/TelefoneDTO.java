package io.oneo.agon.modules.telefone.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.oneo.agon.modules.telefone.type.TelefoneTipo;

import java.io.Serial;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TelefoneDTO implements Serializable
{
    @Serial
    private static final long serialVersionUID = -782188649105570983L;

    public Long id;

    public String ddd;

    public String numero;

    public TelefoneTipo tipo;
}