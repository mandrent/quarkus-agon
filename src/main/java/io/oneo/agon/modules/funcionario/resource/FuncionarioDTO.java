package io.oneo.agon.modules.funcionario.resource;

import io.oneo.agon.modules.cargo.support.dto.CargoDTO;
import io.oneo.agon.modules.funcionario.type.EstadoCivilTipo;
import io.oneo.agon.modules.funcionario.type.SexoTipo;
import io.oneo.agon.modules.geral.endereco.support.dto.EnderecoDTO;
import io.oneo.agon.modules.geral.telefone.support.dto.TelefoneDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class FuncionarioDTO implements Serializable
{
    private static final long serialVersionUID = 4660590782409539353L;

    private Long id;

    private CargoDTO cargo;

    private String matricula;

    private String nome;

    private String sobreNome;

    private String maeNome;

    private String maeSobrenome;

    private EstadoCivilTipo estadoCivilTipo;

    private SexoTipo sexo;

    private int idade;

    private LocalDateTime nascimento;

    private EnderecoDTO endereco;

    private TelefoneDTO telefone;

    private String rgdoc;

    private String cpf;

    private String ctps;

    private String titulo;

    private String pis;

    private String cnh;

    private String reservista;

    private String passaporte;

    private String certidaoCasamento;

    private LocalDateTime admissao;

    private LocalDateTime demissao;

    private List<FuncionarioDependenteDTO> dependenteLista = new ArrayList<FuncionarioDependenteDTO>();
}