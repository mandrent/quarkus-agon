package io.oneo.agon.modules.funcionario.support.dto;

import io.oneo.agon.modules.cargo.support.dto.CargoDTO;
import io.oneo.agon.modules.epi_epc.support.dto.EquipamentoEPIDTO;
import io.oneo.agon.modules.geral.endereco.support.dto.EnderecoDTO;
import io.oneo.agon.modules.geral.telefone.support.dto.TelefoneDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class FuncionarioDTO implements Serializable
{
    private EnderecoDTO endereco;

    private List<TelefoneDTO> telefoneLista = new ArrayList<TelefoneDTO>();

    private CargoDTO cargo;

    private String matricula;

    private LocalDateTime admissao;

    private LocalDateTime demissao;

    private List<EquipamentoEPIDTO> epiLista;

    private FuncionarioDocumentoDTO documento;

    private List<FuncionarioDependenteDTO> dependenteLista = new ArrayList<FuncionarioDependenteDTO>();
}