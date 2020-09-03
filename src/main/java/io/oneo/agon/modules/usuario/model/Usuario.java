package io.oneo.agon.modules.usuario.model;

import io.oneo.agon.modules.usuario.type.GrupoTipo;
import io.oneo.agon.modules.usuario.type.StatusUsuarioTipo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "usuario", schema = "agondb")
public class Usuario extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = 1188263128951105903L;

    @Column(name = "login", unique = true)
    @NotNull
    @Size(min = 6, max = 20)
    public String login;

    @Column(name = "senha")
    @NotNull
    @Size(min = 4, max = 20)
    public String senha;

    @Column(name = "email")
    @Size(min = 10, max = 75)
    public String email;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "grupo_id")
    public GrupoTipo grupo;

    @Column(name = "status_usr")
    @Enumerated(EnumType.ORDINAL)
    public StatusUsuarioTipo status;

    @Column(name = "criacao_dt", insertable = true)
    @NotNull
    public LocalDateTime criacao;

    @Column(name = "acesso_dt", insertable = true)
    @NotNull
    public LocalDateTime acesso;

    @Column(name = "update_dt")
    public LocalDateTime update;

    public Usuario() { }
}