package io.oneo.agon.modules.funcionario.modules.cargo.model;

import io.oneo.agon.modules.empresa.modules.setor.model.EmpresaSetor;
import io.oneo.agon.modules.funcionario.model.Funcionario;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity @Table(name = "cargo", schema = "agondb")
public class Cargo extends PanacheEntity implements Serializable
{
    public static final long serialVersionUID = 1546390991153017423L;

    @OneToOne(mappedBy = "cargo", fetch = FetchType.EAGER)
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    public Funcionario funcionarioID;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "setor_id", referencedColumnName = "id")
    public EmpresaSetor setor;

    @Column(name = "nome")
    @NotNull
    @Size(min = 5, max = 50)
    public String nome;

    @Column(name = "funcao")
    @Size(min = 5, max = 50)
    public String funcao;

    @Column(name = "descricao")
    @Size(min = 5, max = 50)
    public String descricao;

    @Column(name = "refe") @Size(min = 5, max = 100)
    public String referencia;
}