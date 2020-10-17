package io.oneo.agon.modules.common.support.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.io.Serializable;

public abstract class BaseEntity extends PanacheEntity implements Serializable
{
    private static final long serialVersionUID = 4865045538633567508L;
}