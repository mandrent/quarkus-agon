package io.oneo.agon.modules.empresa.modules.cargo.model;

import io.oneo.agon.modules.empresa.model.Empresa;
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
@Table(name = "cargo", schema = "agondb")
public class Cargo implements Serializable
{
    private static final long serialVersionUID = 1546390991153017423L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome", length = 20)
    private String nome;

    @Column(name = "funcao", length = 20)
    private String funcao;

    @Column(name = "setor", length = 20)
    private String setor;

    @Column(name = "referencia", length = 20)
    private String referencia;

    @Column(name = "descricao", length = 50)
    private String descricao;

    @ManyToMany(mappedBy = "cargos", fetch = FetchType.LAZY)
    private Set<Empresa> empresas = new HashSet<>();

    public Cargo() { }

    public void addEmpresa(Empresa empresa)
    {
        empresas.add(empresa);
        empresa.getCargos().add(this);
    }

    public void removeEmpresa(Empresa empresa)
    {
        empresas.remove(empresa);
        empresa.getCargos().remove(this);
    }

}