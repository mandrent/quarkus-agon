package io.oneo.agon.modules.geral.endereco.model;


import io.oneo.agon.modules.geral.endereco.type.LocalComplementoTipo;
import io.oneo.agon.modules.geral.endereco.type.LogradouroComplementoTipo;
import io.oneo.agon.modules.geral.endereco.type.MoradiaComplementoTipo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity @Table(name = "endereco_complemento", schema = "agondb")
public class EnderecoComplemento extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = -1031847733190560481L;

    @OneToOne(mappedBy = "complemento")
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    public Endereco endereco;

    @Column(name = "local") 
    @NotNull
    @Size(min = 4, max = 20) 
    @Enumerated(EnumType.ORDINAL)
    public LocalComplementoTipo local;

    @Column(name = "logradouro_compl")
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    public LogradouroComplementoTipo logradouro;

    @Column(name = "moradia")
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    public MoradiaComplementoTipo moradia;

    @Column(name = "referencia")
    @Size(min = 4, max = 75)
    public String referencia;

    @Column(name = "bloco")
    @Size(min = 1, max = 4)
    public String bloco;

    @Column(name = "andar")
    public int andar;

    @Column(name = "numero")
    public int numero;
}