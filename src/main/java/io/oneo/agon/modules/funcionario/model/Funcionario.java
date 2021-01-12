package io.oneo.agon.modules.funcionario.model;

import io.oneo.agon.modules.cargo.model.Cargo;
import io.oneo.agon.modules.epi_epc.model.EquipamentoEPI;
import io.oneo.agon.modules.funcionario.modules.dependente.model.FuncionarioDependente;
import io.oneo.agon.modules.funcionario.type.EstadoCivilTipo;
import io.oneo.agon.modules.funcionario.type.SexoTipo;
import io.oneo.agon.modules.geral.endereco.model.Endereco;
import io.oneo.agon.modules.geral.telefone.model.Telefone;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter @Setter
@Entity
@Table(name = "funcionario", schema = "agondb")
public class Funcionario implements Serializable
{
    private static final long serialVersionUID = 7816182162884899366L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "matricula", unique = true, length = 15)
    @NotNull
    private String matricula;

    @Column(name = "nome", length = 30)
    @NotNull
    private String nome;

    @Column(name = "sobrenome", length = 50)
    @NotNull
    private String sobreNome;

    @Column(name = "maenome", length = 30)
    @NotNull
    private String maeNome;

    @Column(name = "maesobrenome", length = 50)
    @NotNull
    private String maeSobre;

    @Column(name = "estadocivil", length = 12)
    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoCivilTipo estadoCivilTipo;

    @Column(name = "sexo", length = 9)
    @NotNull
    @Enumerated(EnumType.STRING)
    private SexoTipo sexo;

    @Column(name = "idade")
    @NotNull
    private int idade;

    @Column(name = "nascimento_dt")
    private LocalDateTime nascimento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "telefone_id", referencedColumnName = "id")
    private Telefone telefone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private Cargo cargo;

    @Column(name = "admissao_dt")
    @NotNull
    private LocalDateTime admissao;

    @Column(name = "demissao_dt")
    private LocalDateTime demissao;

    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EquipamentoEPI> epiLista;

    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FuncionarioDependente> dependenteLista = new ArrayList<FuncionarioDependente>();

    public Funcionario() { }
}