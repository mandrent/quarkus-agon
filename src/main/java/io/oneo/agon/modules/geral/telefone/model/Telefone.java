package io.oneo.agon.modules.geral.telefone.model;

import io.oneo.agon.modules.geral.telefone.type.TelefoneTipo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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
}