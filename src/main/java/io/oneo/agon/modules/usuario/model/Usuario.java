package io.oneo.agon.modules.usuario.model;

import io.oneo.agon.modules.usuario.type.GrupoTipo;
import io.oneo.agon.modules.usuario.type.StatusUsuarioTipo;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Entity
@Table(name = "usuario", schema = "agondb")
public class Usuario implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", unique = true, length = 20)
    @NotNull
    private String login;

    @Column(name = "senha", length = 20)
    @NotNull
    private String senha;

    @Column(name = "email", length = 75)
    @Size(min = 10, max = 75)
    private String email;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "grupo_id")
    private GrupoTipo grupo;

    @Column(name = "status_usr")
    @Enumerated(EnumType.ORDINAL)
    private StatusUsuarioTipo status;

    @Column(name = "criacao_dt", insertable = true)
    @NotNull
    private LocalDateTime criacao;

    @Column(name = "acesso_dt", insertable = true)
    private LocalDateTime acesso;

    @Column(name = "update_dt")
    private LocalDateTime update;

    public Usuario() { }

}