package io.oneo.agon.modules.funcionario.model;

import io.oneo.agon.modules.empresa.modules.setor.model.EmpresaSetor;
import io.oneo.agon.modules.epi_epc.model.EquipamentoEPI;
import io.oneo.agon.modules.funcionario.modules.cargo.model.Cargo;
import io.oneo.agon.modules.funcionario.modules.dependente.model.FuncionarioDependente;
import io.oneo.agon.modules.funcionario.modules.documento.model.FuncionarioDocumento;
import io.oneo.agon.modules.geral.endereco.model.Endereco;
import io.oneo.agon.modules.geral.telefone.model.Telefone;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity @Table(name = "funcionario", schema = "agondb")
public class Funcionario extends PanacheEntity implements Serializable
{
    public static final long serialVersionUID = 7816182162884899366L;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "documento_id", referencedColumnName = "id")
    public FuncionarioDocumento documento;

    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY)
    public List<FuncionarioDependente> dependentes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    @NotNull
    public Endereco endereco;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "telefone_id", referencedColumnName = "id")
    public Telefone telefone;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "setor_id", referencedColumnName = "id")
    @NotNull
    public EmpresaSetor setor;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    @NotNull
    public Cargo cargo;

    @Column(name = "matricula", unique = true)
    @Size(min = 3, max = 15)
    public String matricula;

    @Column(name = "admissao_dt")
    public LocalDateTime admissao;

    @Column(name = "demissao_dt")
    public LocalDateTime demissao;

    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY)
    public List<EquipamentoEPI> epis;
}