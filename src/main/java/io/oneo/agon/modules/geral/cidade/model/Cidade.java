package io.oneo.agon.modules.geral.cidade.model;

import io.oneo.agon.modules.geral.estado.model.Estado;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity @Table(name = "cidade", schema = "agondb")
public class Cidade extends PanacheEntity implements Serializable
{
    @Column(name = "nome") @NotNull
    @Size(min = 4, max = 150)
    public String nome;

    @Column(name = "codigo", unique = true) 
    @Size(min = 2, max = 7)
    public String codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id", referencedColumnName = "sigla")
    public Estado estado;
}