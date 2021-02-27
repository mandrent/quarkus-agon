package io.oneo.agon.modules.estado.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Getter @Setter
@Entity
@Table(name = "estado", schema = "agondb")
public class Estado implements Serializable
{
    private static final long serialVersionUID = 714391446942578881L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", unique = true)
    private String nome;

    @Column(name = "sigla", unique = true)
    private String sigla;

    @Column(name = "regiao")
    private String regiao;

    public Estado() { }
}