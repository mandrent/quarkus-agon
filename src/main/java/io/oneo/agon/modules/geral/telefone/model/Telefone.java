package io.oneo.agon.modules.geral.telefone.model;

import io.oneo.agon.modules.geral.telefone.type.TelefoneTipo;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
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