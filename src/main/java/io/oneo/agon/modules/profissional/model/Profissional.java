package io.oneo.agon.modules.profissional.model;

import io.oneo.agon.modules.profissional.type.AreaTipo;
import io.oneo.agon.modules.profissional.type.ProfissionalTipo;
import io.oneo.agon.modules.telefone.model.Telefone;
import io.oneo.agon.modules.usuario.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter @Setter
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
    public Usuario usuario;

    @Column(name = "nome", length = 30)
    public String nome;

    @Column(name = "sobrenome", length = 30)
    public String sobreNome;

    @Column(name = "area", length = 30)
    @Enumerated(EnumType.STRING)
    private AreaTipo area;

    @Column(name = "tipo", length = 30)
    @Enumerated(EnumType.STRING)
    public ProfissionalTipo tipo;

    @Column(name = "drt", length = 10)
    public String drt;

    @Column(name = "sesmt")
    public int sesmt;

    @Column(name = "crm", length = 15)
    public String crm;

    @Column(name = "crea", length = 15)
    public String crea;

    @Column(name = "coren", length = 15)
    public String coren;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "telefone_id", referencedColumnName = "id")
    public Telefone telefone;

    public Profissional() { }
}