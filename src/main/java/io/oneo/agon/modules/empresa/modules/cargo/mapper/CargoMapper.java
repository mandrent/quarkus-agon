package io.oneo.agon.modules.empresa.modules.cargo.mapper;

import io.oneo.agon.modules.common.mapper.BaseMappingConfig;
import io.oneo.agon.modules.empresa.modules.cargo.model.Cargo;
import io.oneo.agon.modules.empresa.modules.cargo.resource.dto.CargoDTO;
import org.mapstruct.Mapper;

@Mapper(config = BaseMappingConfig.class)
public interface CargoMapper extends BaseMappingConfig<Cargo, CargoDTO>
{
}