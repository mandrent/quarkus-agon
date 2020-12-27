package io.oneo.agon.modules.empresa.model;

import io.oneo.agon.modules.empresa.modules.setor.model.EmpresaSetor;
import io.oneo.agon.modules.geral.endereco.model.Endereco;
import io.oneo.agon.modules.geral.telefone.model.Telefone;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "empresa", schema = "agondb")
public class Empresa extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = 8639359712230992611L;

    @Column(name = "nomefantasia", length = 75)
    @NotNull
    public String nomeFantasia;

    @Column(name = "rzsocial", length = 75)
    @NotNull
    public String razaoSocial;

    @Column(name = "cnpj", length = 15)
    @NotNull
    public String cnpj;

    @Column(name = "email", length = 50)
    @NotNull
    public String email;

    @Column(name = "cnae", length = 50)
    @NotNull
    public String cnae;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    public Endereco endereco;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "telefone_id", referencedColumnName = "id")
    public List<Telefone> telefoneLista = new ArrayList<Telefone>();

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    public List<EmpresaSetor> setorLista = new ArrayList<EmpresaSetor>();

    public Empresa() { }
}