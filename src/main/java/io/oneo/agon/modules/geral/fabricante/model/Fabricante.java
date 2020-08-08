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
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "fabricante", schema = "agondb")
public class Fabricante extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = 5558400895022890758L;

    @Column(name = "descricao")
    @NotNull
    @Size(min = 3, max = 30)
    public String descricao;

    @Column(name = "tipo")
    @NotNull
    @Size(min = 3, max = 10)
    public String tipo;




}