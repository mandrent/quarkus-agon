package io.oneo.agon.modules.cidade.model;

import io.oneo.agon.modules.estado.model.Estado;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@AttributeOverride(name = "id", column = @Column(name = "id"))
@Entity
@Table(name = "cidade", schema = "agondb")
public class Cidade extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = -701281650522286275L;

    @Column(name = "nome", length = 150)
    private String nome;

    @Column(name = "codigo", unique = true, length = 7)
    private String codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    private Estado estado;

    public Cidade() { }
}