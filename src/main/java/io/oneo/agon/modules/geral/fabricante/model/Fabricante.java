package io.oneo.agon.modules.geral.fabricante.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "fabricante", schema = "agondb")
public class Fabricante extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = 5558400895022890758L;

    @Column(name = "model", length = 20)
    @NotNull
    public String modelo;

    @Column(name = "tipo", length = 10)
    public String tipo;

    @Column(name = "descricao", length = 30)
    public String descricao;

    public Fabricante() { }
}