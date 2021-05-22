package io.oneo.agon.modules.empresa.modules.cargo.mapper;

import io.oneo.agon.modules.common.mapper.BaseMapping;
import io.oneo.agon.modules.empresa.modules.cargo.model.Cargo;
import io.oneo.agon.modules.empresa.modules.cargo.resource.CargoDTO;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapping.class)
public interface CargoMapper extends BaseMapping<Cargo, CargoDTO> { }