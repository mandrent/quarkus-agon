package io.oneo.agon.modules.common.support.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity extends PanacheEntityBase
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public BaseEntity() { }

    public String toString() {
        return this.getClass().getSimpleName() + "<" + this.id + ">";
    }
}