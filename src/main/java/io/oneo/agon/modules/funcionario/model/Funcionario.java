package io.oneo.agon.modules.funcionario.model;

import io.oneo.agon.modules.cargo.model.Cargo;
import io.oneo.agon.modules.funcionario.modules.dependente.model.FuncionarioDependente;
import io.oneo.agon.modules.funcionario.type.EstadoCivilTipo;
import io.oneo.agon.modules.funcionario.type.SexoTipo;
import io.oneo.agon.modules.geral.endereco.model.Endereco;
import io.oneo.agon.modules.geral.telefone.model.Telefone;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Entity
@Table(name = "funcionario", schema = "agondb")
public class Funcionario implements Serializable
{
    private static final long serialVersionUID = 7816182162884899366L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private Cargo cargo;

    @Column(name = "matricula", unique = true, length = 15)
    private String matricula;

    @Column(name = "nome", length = 30)
    private String nome;

    @Column(name = "sobrenome", length = 50)
    private String sobreNome;

    @Column(name = "maenome", length = 30)
    private String maeNome;

    @Column(name = "maesobrenome", length = 50)
    private String maeSobrenome;

    @Column(name = "estadocivil", length = 12)
    @Enumerated(EnumType.STRING)
    private EstadoCivilTipo estadoCivilTipo;

    @Column(name = "sexo", length = 9)
    @Enumerated(EnumType.STRING)
    private SexoTipo sexo;

    @Column(name = "idade")
    private int idade;

    @Column(name = "nascimento_dt")
    private LocalDateTime nascimento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "telefone_id", referencedColumnName = "id")
    private Telefone telefone;

    @Column(name = "rgdoc", unique = true, length = 30)
    private String rgdoc;

    @Column(name = "cpf", unique = true, length = 30)
    private String cpf;

    @Column(name = "ctps", unique = true, length = 30)
    private String ctps;

    @Column(name = "titulo", unique = true, length = 30)
    private String titulo;

    @Column(name = "pis", unique = true, length = 30)
    private String pis;

    @Column(name = "cnh", unique = true, length = 30)
    private String cnh;

    @Column(name = "reservista", unique = true, length = 30)
    private String reservista;

    @Column(name = "passaporte", unique = true, length = 30)
    private String passaporte;

    @Column(name = "certidao_csnt", unique = true, length = 30)
    private String certidaoCasamento;

    @Column(name = "admissao_dt")
    private LocalDateTime admissao;

    @Column(name = "demissao_dt")
    private LocalDateTime demissao;

    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FuncionarioDependente> dependenteLista = new ArrayList<FuncionarioDependente>();

    public Funcionario() { }
}