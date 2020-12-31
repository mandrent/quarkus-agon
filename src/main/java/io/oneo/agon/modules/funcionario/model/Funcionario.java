package io.oneo.agon.modules.funcionario.model;

import io.oneo.agon.modules.cargo.model.Cargo;
import io.oneo.agon.modules.epi_epc.model.EquipamentoEPI;
import io.oneo.agon.modules.funcionario.modules.dependente.model.FuncionarioDependente;
import io.oneo.agon.modules.funcionario.modules.documento.model.FuncionarioDocumento;
import io.oneo.agon.modules.geral.endereco.model.Endereco;
import io.oneo.agon.modules.geral.telefone.model.Telefone;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "funcionario", schema = "agondb")
public class Funcionario extends PanacheEntity implements Serializable
{
    public static final long serialVersionUID = 7816182162884899366L;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    public Endereco endereco;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "telefone_id", referencedColumnName = "id")
    public List<Telefone> telefoneLista = new ArrayList<Telefone>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    public Cargo cargo;

    @Column(name = "matricula", unique = true, length = 15)
    @NotNull
    public String matricula;

    @Column(name = "admissao_dt")
    @NotNull
    public LocalDateTime admissao;

    @Column(name = "demissao_dt")
    public LocalDateTime demissao;

    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<EquipamentoEPI> epiLista;

    @OneToOne(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    public FuncionarioDocumento documento;

    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<FuncionarioDependente> dependenteLista = new ArrayList<FuncionarioDependente>();

    public Funcionario() { }
}