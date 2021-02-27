package io.oneo.agon.modules.common.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IService<T extends Serializable, ID extends Serializable>
{
    T create(T t);

    T update(T t);

    Optional<T> findByID(ID id);

    void remove(T t);

    void removeByID(ID id);

    List<T> list();
}