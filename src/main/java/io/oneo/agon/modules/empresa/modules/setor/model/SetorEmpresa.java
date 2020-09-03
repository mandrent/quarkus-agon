package io.oneo.agon.modules.empresa.modules.setor.model;

import io.oneo.agon.modules.cargo.model.Cargo;
import io.oneo.agon.modules.empresa.model.Empresa;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "setorempresa", schema = "agondb")
public class SetorEmpresa extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = 3729557140271763536L;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    public Empresa empresa;

    @Column(name = "nome", length = 20)
    @NotNull
    public String nome;

    @Column(name = "descricao", length = 50)
    public String descricao;

    @OneToMany(mappedBy = "setor", fetch = FetchType.LAZY)
    public List<Cargo> cargoList = new ArrayList<Cargo>();

    public SetorEmpresa() { }
}