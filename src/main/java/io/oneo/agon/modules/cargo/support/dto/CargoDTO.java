package io.oneo.agon.modules.cargo.support.dto;

import io.oneo.agon.modules.empresa.support.dto.SetorEmpresaDTO;
import io.oneo.agon.modules.funcionario.support.dto.FuncionarioDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class CargoDTO implements Serializable
{
    private SetorEmpresaDTO setor;

    private String nome;

    private String funcao;

    private String referencia;

    private String descricao;

    private List<FuncionarioDTO> funcionarioLista = new ArrayList<FuncionarioDTO>();
}