package io.oneo.agon.modules.funcionario.modules.documento.model;

import io.oneo.agon.modules.funcionario.model.Funcionario;
import io.oneo.agon.modules.funcionario.modules.documento.type.EstadoCivilTipo;
import io.oneo.agon.modules.funcionario.modules.documento.type.SexoTipo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity @Table(name = "funcionario_documento", schema = "agondb")
public class FuncionarioDocumento extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = 5217427445688373069L;

    @OneToOne(mappedBy = "documento")
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    public Funcionario funcionario;

    @Column(name = "nome")
    @NotNull
    @Size(min = 5, max = 50)
    public String nome;

    @Column(name = "sobre_nome")
    @NotNull
    @Size(min = 5, max = 50)
    public String sobreNome;

    @Column(name = "mae_nome")
    @NotNull
    @Size(min = 5, max = 50)
    public String maeNome;

    @Column(name = "mae_sobre")
    @NotNull
    @Size(min = 5, max = 50)
    public String maeSobre;

    @Column(name = "estado_civil")
    @NotNull
    @Enumerated(EnumType.STRING)
    public EstadoCivilTipo estadoCivilTipo;

    @Column(name = "sexo")
    @NotNull
    public SexoTipo sexo;

    @Column(name = "idade")
    @NotNull
    @Size(min = 1, max = 2)
    public int idade;

    @Column(name = "nascimento_dt")
    public LocalDateTime nascimento;

    @Column(name = "rg_doc", unique = true)
    @NotNull
    @Size(min = 5, max = 10)
    public String rgdoc;

    @Column(name = "cpf", unique = true)
    @NotNull
    @Size(min = 3, max = 11)
    public String cpf;

    @Column(name = "ctps", unique = true)
    @NotNull
    @Size(min = 3, max = 15)
    public String ctps;

    @Column(name = "titulo", unique = true)
    @NotNull
    @Size(min = 5, max = 20)
    public String titulo;

    @Column(name = "pis", unique = true)
    @Size(min = 5, max = 20)
    public String pis;

    @Column(name = "cnh", unique = true)
    @Size(min = 5, max = 20)
    public String cnh;

    @Column(name = "reservista", unique = true)
    @Size(min = 5, max = 20)
    public String reservista;

    @Column(name = "passaporte", unique = true)
    @Size(min = 5, max = 20)
    public String passaporte;

    @Column(name = "cert_casa", unique = true)
    @Size(min = 5, max = 40)
    public String certidaoCasa;
}