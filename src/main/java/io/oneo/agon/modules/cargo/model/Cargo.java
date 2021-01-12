package io.oneo.agon.modules.cargo.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Entity
@Table(name = "cargo", schema = "agondb")
public class Cargo implements Serializable
{
    private static final long serialVersionUID = 1546390991153017423L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 20)
    @NotNull
    private String nome;

    @Column(name = "funcao", length = 20)
    private String funcao;

    @Column(name = "funcao", length = 20)
    private String setor;

    @Column(name = "referencia", length = 20)
    private String referencia;

    @Column(name = "descricao", length = 50)
    private String descricao;

//    @OneToMany(mappedBy = "cargo", fetch = FetchType.EAGER)
//    private List<Funcionario> funcionarioLista = new ArrayList<Funcionario>();

    public Cargo() { }
}