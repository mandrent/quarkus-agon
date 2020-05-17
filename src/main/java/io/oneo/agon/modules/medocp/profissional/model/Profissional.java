package io.oneo.agon.modules.medocp.profissional.model;

import io.oneo.agon.modules.geral.telefone.model.Telefone;
import io.oneo.agon.modules.medocp.profissional.type.CateoriaProfissionalTipo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity @Table(name = "profissional", schema = "agorzdb")
public class Profissional extends PanacheEntity
{
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
    public CateoriaProfissionalTipo categoria;

    @Column(name = "sesmt_id")
    @NotNull
    @Size(min = 3, max = 10)
    public int sesmtID;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "telefone_id", referencedColumnName = "id")
    public Telefone telefone;
}