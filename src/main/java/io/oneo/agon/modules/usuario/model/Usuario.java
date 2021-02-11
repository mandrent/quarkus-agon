package io.oneo.agon.modules.usuario.model;

import io.oneo.agon.modules.usuario.type.GrupoTipo;
import io.oneo.agon.modules.usuario.type.StatusUsuarioTipo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@AttributeOverride(name = "id", column = @Column(name = "id"))
@Entity
@Table(name = "usuario", schema = "agondb")
public class Usuario extends PanacheEntity implements Serializable
{
    @Column(name = "login", unique = true, length = 20)
    public String login;

    @Column(name = "senha", length = 20)
    public String senha;

    @Column(name = "email", length = 75)
    public String email;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "grupo_id")
    public GrupoTipo grupo;

    @Column(name = "status_usr")
    @Enumerated(EnumType.ORDINAL)
    public StatusUsuarioTipo status;

    @Column(name = "criacao_dt", insertable = true)
    public LocalDateTime criacao;

    @Column(name = "acesso_dt", insertable = true)
    public LocalDateTime acesso;

    @Column(name = "update_dt")
    public LocalDateTime update;

    public Usuario() { }

}