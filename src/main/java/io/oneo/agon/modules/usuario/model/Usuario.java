package io.oneo.agon.modules.usuario.model;

import io.oneo.agon.modules.usuario.type.GrupoTipo;
import io.oneo.agon.modules.usuario.type.StatusUsuarioTipo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
@Entity
@Table(name = "usuario", schema = "agondb")
public class Usuario extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = -1176345178514912062L;

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