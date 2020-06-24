package io.oneo.agon.modules.empresa.modules.setor.model;

import io.oneo.agon.modules.empresa.model.Empresa;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity @Table(name = "empresa_setor", schema = "agondb")
public class EmpresaSetor extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = 3729557140271763536L;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    public Empresa empresa;




}