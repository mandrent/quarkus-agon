package io.oneo.agon.modules.geral.endereco.model;

import io.oneo.agon.modules.geral.endereco.type.LocalComplementoTipo;
import io.oneo.agon.modules.geral.endereco.type.LogradouroComplementoTipo;
import io.oneo.agon.modules.geral.endereco.type.MoradiaComplementoTipo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "enderecocomplemento", schema = "agondb")
public class EnderecoComplemento extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = -1031847733190560481L;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    public Endereco endereco;

    @Column(name = "localidade")
    @NotNull
    @Enumerated(EnumType.STRING)
    public LocalComplementoTipo localidade;

    @Column(name = "logradouro_compnt")
    @NotNull
    @Enumerated(EnumType.STRING)
    public LogradouroComplementoTipo logradouro;

    @Column(name = "moradia")
    @NotNull
    @Enumerated(EnumType.STRING)
    public MoradiaComplementoTipo moradia;

    @Column(name = "referencia", length = 75)
    public String referencia;

    @Column(name = "bloco", length = 4)
    public String bloco;

    @Column(name = "andar")
    public int andar;

    @Column(name = "numero")
    public int numero;

    public EnderecoComplemento() { }
}