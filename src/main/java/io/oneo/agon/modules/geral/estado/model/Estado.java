package io.oneo.agon.modules.geral.estado.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity @Table(name = "estado", schema = "agondb")
public class Estado extends PanacheEntity implements Serializable
{
    @Column(name = "nome", unique = true)
    @NotNull
    public String nome;

    @Column(name = "sigla", unique = true)
    @NotNull
    public String sigla;

    @Column(name = "regiao")
    @NotNull
    public String regiao;
}