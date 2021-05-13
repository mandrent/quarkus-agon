package io.oneo.agon.modules.common.mapper;

import org.mapstruct.MapperConfig;

import java.util.List;

@MapperConfig(componentModel = "cdi")
public interface BaseMapping<E, D>
{
    D getDTO(E entity);

    E getModel(D dto);

    List<D> dtoList(List<E> list);

    List<E> modelList(List<D> list);
}