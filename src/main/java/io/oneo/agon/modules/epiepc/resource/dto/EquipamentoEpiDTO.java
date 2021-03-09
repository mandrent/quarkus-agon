package io.oneo.agon.modules.epiepc.resource.dto;

import io.oneo.agon.modules.empresa.modules.funcionario.resource.FuncionarioDTO;
import io.oneo.agon.modules.epiepc.type.AtenuacaoTipo;
import io.oneo.agon.modules.fabricante.support.dto.FabricanteDTO;

import java.io.Serializable;
import java.time.LocalDateTime;

public class EquipamentoEpiDTO implements Serializable
{
    private static final long serialVersionUID = 5707153998197043291L;

    public String descricao;

    public FabricanteDTO fabricante;

    public FuncionarioDTO funcionario;

    public String codigoCA;

    public AtenuacaoTipo atenuacao;

    public int quantidade;

    public LocalDateTime entrega;

    public LocalDateTime devolucao;
}