package io.oneo.agon.modules.funcionario.modules.cargo.model;

import io.oneo.agon.modules.empresa.modules.setor.model.EmpresaSetor;
import io.oneo.agon.modules.funcionario.model.Funcionario;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cargo", schema = "agondb")
public class Cargo extends PanacheEntity implements Serializable
{
    public static final long serialVersionUID = 1546390991153017423L;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "setor_id", referencedColumnName = "idstr")
    public EmpresaSetor setor;

    @Column(name = "nome", length = 20)
    @NotNull
    public String nome;

    @Column(name = "funcao", length = 20)
    public String funcao;

    @Column(name = "referencia", length = 20)
    public String referencia;

    @Column(name = "descricao", length = 50)
    public String descricao;

    @OneToMany(mappedBy = "cargo", fetch = FetchType.EAGER)
    public List<Funcionario> funcionarioLista = new ArrayList<Funcionario>();
}