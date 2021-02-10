package io.oneo.agon.modules.endereco.model;

import io.oneo.agon.modules.cidade.model.Cidade;
import io.oneo.agon.modules.endereco.type.ComplementoLogradouroTipo;
import io.oneo.agon.modules.endereco.type.LogradouroTipo;
import io.oneo.agon.modules.endereco.type.MoradiaComplementoTipo;
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
@Table(name = "endereco", schema = "agondb")
public class Endereco implements Serializable
{
    private static final long serialVersionUID = -2532079074872346697L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cidade_id", referencedColumnName = "id")
    private Cidade cidade;

    @Column(name = "logradouro")
    @Enumerated(EnumType.STRING)
    private LogradouroTipo logradouroTipo;

    @Column(name = "moradia")
    @Enumerated(EnumType.STRING)
    private MoradiaComplementoTipo moradiaTipo;

    @Column(name = "complemento")
    @Enumerated(EnumType.STRING)
    private ComplementoLogradouroTipo complementoTipo;

    @Column(name = "numero")
    private int numero;

    @Column(name = "bairro", length = 30)
    private String bairro;

    @Column(name = "setor", length = 15)
    private String setor;

    @Column(name = "cep", length = 8)
    private String cep;

    @Column(name = "referencia", length = 75)
    private String referencia;

    @Column(name = "bloco", length = 4)
    private String bloco;

    @Column(name = "andar")
    private int andar;

    @Column(name = "aptonro")
    private int aptoNumero;

    public Endereco() { }
}