package io.oneo.agon.modules.common.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IService<E extends Serializable, ID extends Serializable>
{
    void create(E t);

    void update(E t);

    Optional<E> findByID(ID id);

    void remove(E t);

    void removeByID(ID id);

    List<E> list();

}