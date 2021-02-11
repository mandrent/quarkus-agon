package io.oneo.agon.modules.empresa.model;

import io.oneo.agon.modules.empresa.modules.cargo.model.Cargo;
import io.oneo.agon.modules.endereco.model.Endereco;
import io.oneo.agon.modules.telefone.model.Telefone;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter @Setter
@Entity
@Table(name = "empresa", schema = "agondb")
public class Empresa implements Serializable
{
    private static final long serialVersionUID = 8639359712230992611L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomefantasia", length = 75)
    @NotNull
    private String nomeFantasia;

    @Column(name = "rzsocial", length = 75)
    @NotNull
    private String razaoSocial;

    @Column(name = "cnpj", length = 15)
    @NotNull
    private String cnpj;

    @Column(name = "email", length = 50)
    @NotNull
    private String email;

    @Column(name = "cnae", length = 50)
    @NotNull
    private String cnae;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "telefone_id", referencedColumnName = "id")
    private Telefone telefone;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cargoempresa",
            joinColumns = { @JoinColumn(name = "cargo_id") },
            inverseJoinColumns = { @JoinColumn(name = "empresa_id") })
    private Set<Cargo> cargos = new HashSet<Cargo>();

    public Empresa() { }

    public void addCargo(Cargo cargo)
    {
        this.cargos.add(cargo);
        cargo.getEmpresas().add(this);
    }

    public void removeCargo(Cargo cargo)
    {
        this.cargos.remove(cargo);
        cargo.getEmpresas().remove(this);
    }

}