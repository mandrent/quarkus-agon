package io.oneo.agon.modules.empresa.resource.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.oneo.agon.modules.endereco.resource.dto.EnderecoDTO;
import io.oneo.agon.modules.telefone.resource.dto.TelefoneDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmpresaDTO implements Serializable
{
    private static final long serialVersionUID = 1156444578272868373L;

    private Long id;

    private String nomeFantasia;

    private String razaoSocial;

    private String cnpj;

    private String email;

    private String cnae;

    private EnderecoDTO endereco;

    private List<TelefoneDTO> telefoneLista = new ArrayList<TelefoneDTO>();
}