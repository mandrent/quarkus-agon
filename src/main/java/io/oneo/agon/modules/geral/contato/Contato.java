package io.oneo.agon.modules.geral.contato;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity @Table(name = "contato", schema = "agondb")
public class Contato extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = 9022996150945077270L;











}