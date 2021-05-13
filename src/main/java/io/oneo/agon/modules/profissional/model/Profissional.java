package io.oneo.agon.modules.profissional.model;

import io.oneo.agon.modules.profissional.type.AreaTipo;
import io.oneo.agon.modules.profissional.type.ProfissionalTipo;
import io.oneo.agon.modules.telefone.model.Telefone;
import io.oneo.agon.modules.usuario.model.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "profissional", schema = "agondb")
public class Profissional implements Serializable
{
    private static final long serialVersionUID = -2283230030471863819L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @Column(name = "nome", length = 30)
    private String nome;

    @Column(name = "sobrenome", length = 30)
    private String sobreNome;

    @Column(name = "area")
    @Enumerated(EnumType.STRING)
    private AreaTipo area;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private ProfissionalTipo tipo;

    @Column(name = "drt", length = 15)
    private String drt;

    @Column(name = "sesmt", length = 10)
    private int sesmt;

    @Column(name = "crm", length = 15)
    private String crm;

    @Column(name = "crea", length = 15)
    private String crea;

    @Column(name = "coren", length = 15)
    private String coren;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "telefone_id", referencedColumnName = "id")
    private Telefone telefone;

    public Profissional() { }

}