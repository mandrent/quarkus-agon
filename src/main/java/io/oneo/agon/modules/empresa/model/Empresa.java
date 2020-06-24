package io.oneo.agon.modules.empresa.model;

import io.oneo.agon.modules.empresa.modules.setor.model.EmpresaSetor;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity @Table(name = "empresa", schema = "agondb")
public class Empresa extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = 8639359712230992611L;

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    public List<EmpresaSetor> setores;
}