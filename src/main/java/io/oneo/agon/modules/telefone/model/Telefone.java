package io.oneo.agon.modules.telefone.model;

import io.oneo.agon.modules.telefone.type.TelefoneTipo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Getter @Setter
@Entity
@Table(name = "telefone", schema = "agondb")
public class Telefone implements Serializable
{
    private static final long serialVersionUID = -2069305261353665287L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ddd", length = 2)
    private String ddd;

    @Column(name = "numero", length = 9)
    private String numero;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TelefoneTipo tipo;

    public Telefone() { }
}