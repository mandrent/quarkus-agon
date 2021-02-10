package io.oneo.agon.modules.cidade.model;

import io.oneo.agon.modules.estado.model.Estado;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cidade", schema = "agondb")
public class Cidade extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = -701281650522286275L;

    @Column(name = "nome")
    @NotNull
    @Size(min = 4, max = 150)
    public String nome;

    @Column(name = "codigo", unique = true) 
    @Size(min = 2, max = 7)
    public String codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    public Estado estado;

    public Cidade() { }
}