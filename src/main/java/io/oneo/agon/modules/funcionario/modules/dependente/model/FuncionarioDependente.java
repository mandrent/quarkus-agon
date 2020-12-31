package io.oneo.agon.modules.funcionario.modules.dependente.model;

import io.oneo.agon.modules.funcionario.model.Funcionario;
import io.oneo.agon.modules.funcionario.modules.dependente.type.DependenteSexoTipo;
import io.oneo.agon.modules.funcionario.modules.dependente.type.DependenteTipo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "funcionariodependente", schema = "agondb")
public class FuncionarioDependente extends PanacheEntity implements Serializable
{
    public static final long serialVersionUID = 5674229360067270924L;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    public Funcionario funcionario;

    @Column(name = "nome")
    @NotNull
    @Size(min = 3, max = 30)
    public String nome;

    @Column(name = "sobre_nome")
    @NotNull
    @Size(min = 3, max = 50)
    public String sobreNome;

    @Column(name = "sexo")
    @NotNull
    @Enumerated(EnumType.STRING)
    public DependenteSexoTipo sexoTipo;

    @Column(name = "idade")
    @NotNull
    @Size(min = 1, max = 2)
    public int idade;

    @Column(name = "filiacao")
    @NotNull
    @Enumerated(EnumType.STRING)
    public DependenteTipo dependenteTipo;

    @Column(name = "rgdoc", unique = true, length = 15)
    public String rgdoc;

    @Column(name = "cpf", unique = true, length = 11)
    public String cpf;

    @Column(name = "nasc_cert", length = 20)
    public String certidaoNascimento;

    @Column(name = "casa_cert", length = 30)
    public String certidaoCasamento;

    @Column(name = "vacina_cart", length = 20)
    public String carteiraVacina;

    public FuncionarioDependente() { }
}