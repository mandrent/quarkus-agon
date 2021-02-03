package io.oneo.agon.modules.epiepc.support.dto;

import io.oneo.agon.modules.epiepc.type.AtenuacaoTipo;
import io.oneo.agon.modules.funcionario.resource.FuncionarioDTO;
import io.oneo.agon.modules.geral.fabricante.support.dto.FabricanteDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
public class EquipamentoEpiDTO implements Serializable
{
    private static final long serialVersionUID = 5707153998197043291L;

    private String descricao;

    private FabricanteDTO fabricante;

    private FuncionarioDTO funcionario;

    private String codigoCA;

    private AtenuacaoTipo atenuacao;

    private int quantidade;

    private LocalDateTime entrega;

    private LocalDateTime devolucao;
}