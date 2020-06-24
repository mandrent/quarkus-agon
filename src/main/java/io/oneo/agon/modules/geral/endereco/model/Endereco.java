package io.oneo.agon.modules.geral.endereco.model;

import io.oneo.agon.modules.geral.cidade.model.Cidade;
import io.oneo.agon.modules.geral.endereco.type.LogradouroTipo;
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
@Entity @Table(name = "endereco", schema = "agondb")
public class Endereco extends PanacheEntity implements Serializable
{
    public static final long serialVersionUID = -1991068383330482288L;

    @Column(name = "logradouro")
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    public LogradouroTipo logradouro;

    @Column(name = "numero")
    @NotNull
    public int numero;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "complemento_id", referencedColumnName = "id")
    public EnderecoComplemento complemento;

    @Column(name = "bairro")
    @Size(min = 5, max = 30)
    public String bairro;

    @Column(name = "cep")
    @Size(min = 5, max = 8)
    public String cep;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cidade_id", referencedColumnName = "id")
    public Cidade cidade;
}