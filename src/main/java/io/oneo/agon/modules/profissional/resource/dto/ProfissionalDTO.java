package io.oneo.agon.modules.profissional.resource.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.oneo.agon.modules.profissional.type.AreaTipo;
import io.oneo.agon.modules.profissional.type.ProfissionalTipo;
import io.oneo.agon.modules.telefone.resource.dto.TelefoneDTO;
import io.oneo.agon.modules.usuario.resource.dto.UsuarioDTO;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfissionalDTO implements Serializable
{
    private static final long serialVersionUID = -6542982507537015835L;

    public Long id;

    public UsuarioDTO usuario;

    public String nome;

    public String sobreNome;

    public AreaTipo area;

    public ProfissionalTipo tipo;

    public String drt;

    public int sesmt;

    public String crm;

    public String crea;

    public String coren;

    public TelefoneDTO telefone;
}