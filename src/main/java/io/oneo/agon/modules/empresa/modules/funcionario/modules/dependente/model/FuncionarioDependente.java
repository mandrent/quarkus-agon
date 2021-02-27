package io.oneo.agon.modules.empresa.modules.funcionario.modules.dependente.model;

import io.oneo.agon.modules.empresa.modules.funcionario.model.Funcionario;
import io.oneo.agon.modules.empresa.modules.funcionario.modules.dependente.type.DependenteSexoTipo;
import io.oneo.agon.modules.empresa.modules.funcionario.modules.dependente.type.DependenteTipo;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter @Setter
@Entity
@Table(name = "funcionariodependente", schema = "agondb")
public class FuncionarioDependente implements Serializable
{
    private static final long serialVersionUID = 5674229360067270924L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    private Funcionario funcionario;

    @Column(name = "nome")
    @Size(min = 3, max = 30)
    private String nome;

    @Column(name = "sobrenome")
    @Size(min = 3, max = 50)
    private String sobreNome;

    @Column(name = "sexo")
    @Enumerated(EnumType.STRING)
    private DependenteSexoTipo sexoTipo;

    @Column(name = "idade")
    @Size(min = 1, max = 2)
    private int idade;

    @Column(name = "filiacao")
    @Enumerated(EnumType.STRING)
    private DependenteTipo dependenteTipo;

    @Column(name = "rgdoc", unique = true, length = 15)
    private String rgdoc;

    @Column(name = "cpf", unique = true, length = 11)
    private String cpf;

    @Column(name = "nascimento_crt", length = 20)
    private String certidaoNascimento;

    @Column(name = "vacinacart", length = 20)
    private String carteiraVacina;

    public FuncionarioDependente() { }
}