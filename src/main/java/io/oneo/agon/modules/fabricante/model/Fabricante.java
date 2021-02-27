package io.oneo.agon.modules.fabricante.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter @Setter
@Entity
@Table(name = "fabricante", schema = "agondb")
public class Fabricante implements Serializable
{
    private static final long serialVersionUID = 5558400895022890758L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model", length = 20)
    @NotNull
    public String modelo;

    @Column(name = "tipo", length = 10)
    public String tipo;

    @Column(name = "descricao", length = 30)
    public String descricao;

    public Fabricante() { }
}