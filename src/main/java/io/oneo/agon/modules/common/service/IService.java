package io.oneo.agon.modules.common.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IService<E extends Serializable, ID extends Serializable>
{
    void create(E e);

    void update(E e);

    Optional<E> findByID(ID id);

    void remove(E e);

    void removeByID(ID id);

    List<E> list();
}