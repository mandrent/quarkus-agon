package io.oneo.agon.modules.funcionario.modules.documento.model;

import io.oneo.agon.modules.funcionario.model.Funcionario;
import io.oneo.agon.modules.funcionario.modules.documento.type.EstadoCivilTipo;
import io.oneo.agon.modules.funcionario.modules.documento.type.SexoTipo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "funcionariodocumento", schema = "agondb")
public class FuncionarioDocumento extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = 5217427445688373069L;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    public Funcionario funcionario;

    @Column(name = "nome", length = 30)
    @NotNull
    public String nome;

    @Column(name = "sobre_nome", length = 50)
    @NotNull
    public String sobreNome;

    @Column(name = "mae_nome", length = 30)
    @NotNull
    public String maeNome;

    @Column(name = "mae_sobrenm", length = 50)
    @NotNull
    public String maeSobre;

    @Column(name = "estado_cvl", length = 12)
    @NotNull
    @Enumerated(EnumType.STRING)
    public EstadoCivilTipo estadoCivilTipo;

    @Column(name = "sexo", length = 6)
    @NotNull
    public SexoTipo sexo;

    @Column(name = "idade")
    @NotNull
    public int idade;

    @Column(name = "nascimento_dt")
    public LocalDateTime nascimento;

    @Column(name = "rgdoc", unique = true, length = 15)
    @NotNull
    public String rgdoc;

    @Column(name = "cpf", unique = true, length = 11)
    @NotNull
    public String cpf;

    @Column(name = "ctps", unique = true, length = 15)
    @NotNull
    public String ctps;

    @Column(name = "titulo", unique = true, length = 20)
    @NotNull
    public String titulo;

    @Column(name = "pis", unique = true, length = 20)
    public String pis;

    @Column(name = "cnh", unique = true, length = 20)
    public String cnh;

    @Column(name = "reservista", unique = true, length = 20)
    public String reservista;

    @Column(name = "passaporte", unique = true, length = 20)
    public String passaporte;

    @Column(name = "cert_casa", unique = true, length = 40)
    public String certidaoCasa;

    public FuncionarioDocumento() { }
}