package io.oneo.agon.modules.telefone.mapper;

import io.oneo.agon.modules.common.mapper.BaseMappingConfig;
import io.oneo.agon.modules.telefone.model.Telefone;
import io.oneo.agon.modules.telefone.resource.dto.TelefoneDTO;
import org.mapstruct.Mapper;

@Mapper(config = BaseMappingConfig.class)
public interface TelefoneMapper extends BaseMappingConfig<Telefone, TelefoneDTO>
{
}
