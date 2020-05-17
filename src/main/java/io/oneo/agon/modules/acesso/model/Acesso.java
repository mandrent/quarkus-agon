package io.oneo.agon.modules.acesso.model;

import io.oneo.agon.modules.acesso.modules.usuario.model.Usuario;
import io.oneo.agon.modules.acesso.modules.grupo.model.Grupo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity @Table(name = "sec_acesso", schema = "agondb")
public class Acesso extends PanacheEntity implements Serializable
{
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    public List<Usuario> usuarios;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "grupo_id", referencedColumnName = "id")
    public List<Grupo> grupos;

    @Column(name = "adc")
    @NotNull
    public int adc;

    @Column(name = "edt")
    @NotNull
    public int edt;

    @Column(name = "rmv")
    @NotNull
    public int rmv;

    @Column(name = "vis")
    @NotNull
    public int viw;

    @Column(name = "spc")
    @NotNull
    public int spc;
}