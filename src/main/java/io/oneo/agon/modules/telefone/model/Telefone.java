package io.oneo.agon.modules.telefone.model;

import io.oneo.agon.modules.telefone.type.TelefoneTipo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AttributeOverride(name = "id", column = @Column(name = "id"))
@Entity
@Table(name = "telefone", schema = "agondb")
public class Telefone extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = -2069305261353665287L;

    @Column(name = "ddd", length = 2)
    public String ddd;

    @Column(name = "numero", length = 9)
    public String numero;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    public TelefoneTipo tipo;

    public Telefone() { }
}