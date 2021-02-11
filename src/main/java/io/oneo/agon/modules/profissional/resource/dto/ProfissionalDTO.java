package io.oneo.agon.modules.profissional.resource.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.oneo.agon.modules.profissional.type.AreaTipo;
import io.oneo.agon.modules.profissional.type.ProfissionalTipo;
import io.oneo.agon.modules.telefone.resource.dto.TelefoneDTO;
import io.oneo.agon.modules.usuario.resource.dto.UsuarioDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfissionalDTO implements Serializable
{
    private static final long serialVersionUID = 9123656346626668497L;

    private Long id;

    private UsuarioDTO usuario;

    private String nome;

    private String sobreNome;

    private AreaTipo area;

    private ProfissionalTipo tipo;

    private String drt;

    private int sesmt;

    private String crm;

    private String crea;

    private String coren;

    public TelefoneDTO telefone;
}