package io.oneo.agon.modules.cidade.model;

import io.oneo.agon.modules.estado.model.Estado;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Getter @Setter
@Entity
@Table(name = "cidade", schema = "agondb")
public class Cidade implements Serializable
{
    private static final long serialVersionUID = -701281650522286275L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 150)
    private String nome;

    @Column(name = "codigo", unique = true)
    private String codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    private Estado estado;

    public Cidade() { }
}