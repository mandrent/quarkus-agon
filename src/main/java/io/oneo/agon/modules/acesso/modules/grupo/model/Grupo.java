package io.oneo.agon.modules.acesso.modules.grupo.model;

import io.oneo.agon.modules.acesso.modules.usuario.model.Usuario;
import io.oneo.agon.modules.acesso.modules.usuario.type.GrupoTipo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity @Table(name = "sec_grupo", schema = "agondb")
public class Grupo extends PanacheEntity implements Serializable
{
    @Column(name = "descricao")
    @Enumerated(EnumType.STRING)
    public GrupoTipo tipo;

    @OneToMany(mappedBy = "grupo", fetch = FetchType.LAZY)
    public Set<Usuario> usuarios;
}