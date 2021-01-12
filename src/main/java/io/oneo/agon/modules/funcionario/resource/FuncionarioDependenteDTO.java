package io.oneo.agon.modules.funcionario.resource;

import io.oneo.agon.modules.funcionario.modules.dependente.type.DependenteSexoTipo;
import io.oneo.agon.modules.funcionario.modules.dependente.type.DependenteTipo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class FuncionarioDependenteDTO implements Serializable
{
    private static final long serialVersionUID = -4327026731494165689L;

    private String nome;

    private String sobreNome;

    private DependenteSexoTipo sexoTipo;

    private int idade;

    private DependenteTipo dependenteTipo;

    private String rgdoc;

    private String cpf;

    private String certidaoNascimento;

    private String certidaoCasamento;

    private String carteiraVacina;
}

