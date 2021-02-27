package io.oneo.agon.modules.usuario.model;

import io.oneo.agon.modules.usuario.type.GrupoTipo;
import io.oneo.agon.modules.usuario.type.StatusUsuarioTipo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Getter @Setter
@Entity
@Table(name = "usuario", schema = "agondb")
public class Usuario implements Serializable
{
    private static final long serialVersionUID = -1176345178514912062L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "login", unique = true, length = 20)
    private String login;

    @Column(name = "senha", length = 20)
    private String senha;

    @Column(name = "email", length = 75)
    private String email;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "grupo_id")
    private GrupoTipo grupo;

    @Column(name = "status_usr")
    @Enumerated(EnumType.ORDINAL)
    private StatusUsuarioTipo status;

    @Column(name = "criacao_dt", insertable = true)
    private LocalDateTime criacao;

    @Column(name = "acesso_dt", insertable = true)
    private LocalDateTime acesso;

    @Column(name = "update_dt")
    private LocalDateTime update;

    public Usuario() { }

}