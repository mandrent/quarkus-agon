package io.oneo.agon.modules.funcionario.modules.dependente.model;

import io.oneo.agon.modules.funcionario.model.Funcionario;
import io.oneo.agon.modules.funcionario.modules.dependente.type.DependenteFuncionarioTipo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity @Table(name = "func_dependente", schema = "agondb")
public class FuncionarioDependente extends PanacheEntity implements Serializable
{
    public static final long serialVersionUID = 5674229360067270924L;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    public Funcionario funcionario;

    @Column(name = "nome")
    @NotNull
    @Size(min = 3, max = 50)
    public String nome;

    @Column(name = "sobre_nome")
    @NotNull
    @Size(min = 3, max = 50)
    public String sobreNome;

    @Column(name = "sexo")
    @NotNull
    @Size(min = 1, max = 1)
    public Character sexo;

    @Column(name = "idade")
    @NotNull
    @Size(min = 1, max = 2)
    public int idade;

    @Column(name = "filiacao")
    @NotNull
    @Enumerated(EnumType.STRING)
    public DependenteFuncionarioTipo dependenteTipo;

    @Column(name = "idrg")
    @Size(min = 5, max = 10)
    public String idrg;

    @Column(name = "cpf")
    @Size(min = 3, max = 11)
    public String cpf;

    @Column(name = "cert_nasc")
    @Size(min = 5, max = 20)
    public String certidaoNascimento;

    @Column(name = "cert_casa")
    @Size(min = 5, max = 30)
    public String certidaoCasamento;

    @Column(name = "cart_vacina")
    @Size(min = 5, max = 20)
    public String carteiraVacina;
}