package io.oneo.agon.modules.estado.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@AttributeOverride(name = "id", column = @Column(name = "id"))
@Entity
@Table(name = "estado", schema = "agondb")
public class Estado extends PanacheEntity implements Serializable
{
    @Column(name = "nome", unique = true)
    public String nome;

    @Column(name = "sigla", unique = true)
    public String sigla;

    @Column(name = "regiao")
    public String regiao;

    public Estado() { }
}