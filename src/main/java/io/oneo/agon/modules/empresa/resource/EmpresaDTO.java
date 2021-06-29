package io.oneo.agon.modules.empresa.resource;

import io.oneo.agon.modules.endereco.resource.EnderecoDTO;
import io.oneo.agon.modules.telefone.resource.TelefoneDTO;

import java.io.Serializable;

public class EmpresaDTO implements Serializable
{
    private static final long serialVersionUID = 1156444578272868373L;

    public Long id;

    public String nomeFantasia;

    public String razaoSocial;

    public String cnpj;

    public String email;

    public String cnae;

    public EnderecoDTO endereco;

    public TelefoneDTO telefone;
}