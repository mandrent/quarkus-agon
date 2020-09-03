package io.oneo.agon.modules.geral.endereco.model;

import io.oneo.agon.modules.geral.cidade.model.Cidade;
import io.oneo.agon.modules.geral.endereco.type.LogradouroTipo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "endereco", schema = "agondb")
public class Endereco extends PanacheEntity implements Serializable
{
    public static final long serialVersionUID = -1991068383330482288L;

    @Column(name = "logradouro")
    @Enumerated(EnumType.STRING)
    @NotNull
    public LogradouroTipo logradouro;

    @Column(name = "numero")
    @NotNull
    public int numero;

    @OneToOne(mappedBy = "endereco", fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    public EnderecoComplemento complemento;

    @Column(name = "bairro", length = 30)
    public String bairro;

    @Column(name = "setor", length = 15)
    public String setor;

    @Column(name = "cep", length = 8)
    public String cep;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cidade_id", referencedColumnName = "id")
    public Cidade cidade;

    public Endereco() { }
}