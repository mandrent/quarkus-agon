package io.oneo.agon.modules.acesso.modules.usuario.model;

import io.oneo.agon.modules.acesso.modules.usuario.type.StatusUsuarioTipo;
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
@Entity @Table(name = "sec_usuario", schema = "agondb")
public class Usuario extends PanacheEntity implements Serializable
{
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
}