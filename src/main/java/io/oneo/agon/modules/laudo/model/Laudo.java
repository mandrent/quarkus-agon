package io.oneo.agon.modules.laudo.model;

import io.oneo.agon.modules.laudo.type.LaudoTipo;
import io.oneo.agon.modules.profissional.model.Profissional;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Getter @Setter
@Entity
@Table(name = "laudo", schema = "agondb")
public class Laudo implements Serializable
{
    private static final long serialVersionUID = -361796415983751094L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profissional_id", referencedColumnName = "id")
    private Profissional responsavel;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private LaudoTipo tipo;


}