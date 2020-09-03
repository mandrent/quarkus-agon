package io.oneo.agon.modules.empresa.support.dto;

import io.oneo.agon.modules.cargo.support.dto.CargoDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class SetorEmpresaDTO implements Serializable
{
    private static final long serialVersionUID = -4706722998617368472L;

    private EmpresaDTO empresa;

    private String nome;

    private String descricao;

    private List<CargoDTO> cargoList = new ArrayList<CargoDTO>();
}