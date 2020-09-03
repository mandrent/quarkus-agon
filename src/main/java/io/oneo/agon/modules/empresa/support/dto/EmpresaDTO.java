package io.oneo.agon.modules.empresa.support.dto;

import io.oneo.agon.modules.geral.endereco.support.dto.EnderecoDTO;
import io.oneo.agon.modules.geral.telefone.support.dto.TelefoneDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class EmpresaDTO implements Serializable
{
    private static final long serialVersionUID = 1156444578272868373L;

    private String nomeFantasia;

    private String razaoSocial;

    private String cnpj;

    private String email;

    private String cnae;

    private EnderecoDTO endereco;

    private List<TelefoneDTO> telefoneLista = new ArrayList<TelefoneDTO>();

    private List<SetorEmpresaDTO> setorLista = new ArrayList<SetorEmpresaDTO>();
}