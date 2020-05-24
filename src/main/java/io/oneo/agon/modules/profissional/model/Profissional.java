package io.oneo.agon.modules.profissional.model;

import io.oneo.agon.modules.acesso.model.Acesso;
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
@EqualsAndHashCode(of = "id")
@Entity @Table(name = "profissional", schema = "agondb")
public class Profissional extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = -2283230030471863819L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acesso_id", referencedColumnName = "id")
    public Acesso acesso;

    @Column(name = "nome")
    @NotNull
    @Size(min = 3, max = 30)
    public String nome;

    @Column(name = "sobre_nome")
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
    @JoinColumn(name = "telefone_id", referencedColumnName = "id")
    public Set<Telefone> telefones;
}