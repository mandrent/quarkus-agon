package io.oneo.agon.modules.med_ocp.model;

import io.oneo.agon.modules.profissional.model.Profissional;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "medico")
public class Medico extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = -1333576479605572347L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profissional_id", referencedColumnName = "id")
    public Profissional profissional;

    @Column(name = "crm", unique = true)
    @NotNull
    @Size(min = 3, max = 10)
    public String crm;

    public Medico() { }
}