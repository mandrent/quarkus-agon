package io.oneo.agon.modules.common.mapper;

import org.mapstruct.MapperConfig;

import java.util.List;

@MapperConfig(componentModel = "cdi")
public interface BaseMappingConfig<E, D>
{
    D convertToDTO(E entity);

    E convertToModel(D dto);

    List<D> convertToDtoList(List<E> list);

    List<E> convertToModelList(List<D> list);
}