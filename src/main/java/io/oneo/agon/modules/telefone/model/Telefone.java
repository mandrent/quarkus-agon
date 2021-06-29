package io.oneo.agon.modules.telefone.model;

import io.oneo.agon.modules.telefone.type.TelefoneTipo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "telefone", schema = "agondb")
public class Telefone extends PanacheEntity implements Serializable
{
    @Serial
    private static final long serialVersionUID = -4492124224253497058L;

    @Column(name = "ddd", length = 2)
    public String ddd;

    @Column(name = "numero", length = 9)
    public String numero;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    public TelefoneTipo tipo;

    public Telefone() { }
}