package io.oneo.agon.infra.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IService<T extends Serializable, ID extends Serializable>
{
    void criar(T t);

    T atualizar(T t);

    Optional<T> buscarPorID(ID id);

    void remover(T t);

    void removerPorID(ID id);

    List<T> listar();

    <T> T convertOne(Object source, Class<T> target);

    <D, T> List<D> convertList(final Collection<T> sourceList, Class<D> target);
}