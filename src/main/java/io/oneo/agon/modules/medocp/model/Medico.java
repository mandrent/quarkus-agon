package io.oneo.agon.modules.medocp.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity @Table(name = "medico")
public class Medico extends PanacheEntity
{
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "pro_id", referencedColumnName = "id")
//    public Profissional profissional;

    @Column(name = "crm", unique = true)
    @NotNull
    @Size(min = 3, max = 10)
    public String crm;

//    @OneToMany(mappedBy = "medicoID", fetch = FetchType.LAZY)
//    public List<ProgramaPcmso> pcmsoLista;

//    @OneToMany(mappedBy = "medicoID", fetch = FetchType.LAZY)
//    public List<AtestadoASO> asoLista;

//    @OneToMany(mappedBy = "medicoID", fetch = FetchType.LAZY)
//    public List<Exames> exameLista;
}