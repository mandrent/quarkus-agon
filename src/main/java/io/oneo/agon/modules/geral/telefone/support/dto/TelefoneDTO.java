package io.oneo.agon.modules.geral.telefone.support.dto;

import io.oneo.agon.modules.geral.telefone.type.TelefoneTipo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class TelefoneDTO implements Serializable
{
    private static final long serialVersionUID = -782188649105570983L;

    private String ddd;

    private String numero;

    private TelefoneTipo tipo;
}
