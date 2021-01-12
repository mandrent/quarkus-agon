package io.oneo.agon.modules.empresa.model;

import io.oneo.agon.modules.empresa.modules.setor.model.EmpresaSetor;
import io.oneo.agon.modules.geral.endereco.model.Endereco;
import io.oneo.agon.modules.geral.telefone.model.Telefone;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "empresa", schema = "agondb")
public class Empresa implements Serializable
{
    private static final long serialVersionUID = 8639359712230992611L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomefantasia", length = 75)
    @NotNull
    private String nomeFantasia;

    @Column(name = "rzsocial", length = 75)
    @NotNull
    private String razaoSocial;

    @Column(name = "cnpj", length = 15)
    @NotNull
    private String cnpj;

    @Column(name = "email", length = 50)
    @NotNull
    private String email;

    @Column(name = "cnae", length = 50)
    @NotNull
    private String cnae;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "telefone_id", referencedColumnName = "id")
    private List<Telefone> telefoneLista = new ArrayList<Telefone>();

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    private List<EmpresaSetor> setorLista = new ArrayList<EmpresaSetor>();

    public Empresa() { }
}