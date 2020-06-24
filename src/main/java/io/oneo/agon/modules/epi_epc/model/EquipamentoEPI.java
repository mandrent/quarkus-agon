package io.oneo.agon.modules.epi_epc.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity @Table(name = "eqp_epi", schema = "agondb")
public class EquipamentoEPI extends PanacheEntity implements Serializable
{
}