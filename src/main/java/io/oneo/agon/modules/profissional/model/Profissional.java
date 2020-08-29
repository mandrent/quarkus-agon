package io.oneo.agon.modules.profissional.model;

import io.oneo.agon.modules.usuario.model.Usuario;
import io.oneo.agon.modules.geral.telefone.model.Telefone;
import io.oneo.agon.modules.profissional.type.ProfissionalTipo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "profissional", schema = "agondb")
public class Profissional extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = -2283230030471863819L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "idusr")
    public Usuario usuario;

    @Column(name = "nome")
    @NotNull
    @Size(min = 3, max = 30)
    public String nome;

    @Column(name = "sobrenome")
    @NotNull
    @Size(min = 3, max = 30)
    public String sobreNome;

    @Column(name = "drt_code")
    @NotNull
    @Size(min = 3, max = 10)
    public String codigoDRT;

    @Column(name = "categoria")
    @Enumerated(EnumType.ORDINAL)
    public ProfissionalTipo tipo;

    @Column(name = "sesmt_id")
    @NotNull
    @Size(min = 3, max = 10)
    public int sesmtID;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "telefone_id", referencedColumnName = "idtel")
    public Set<Telefone> telefones;
}