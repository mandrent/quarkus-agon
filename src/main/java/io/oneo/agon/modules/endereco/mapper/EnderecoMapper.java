package io.oneo.agon.modules.endereco.mapper;

import io.oneo.agon.modules.common.mapper.BaseMappingConfig;
import io.oneo.agon.modules.endereco.model.Endereco;
import io.oneo.agon.modules.endereco.resource.dto.EnderecoDTO;
import org.mapstruct.Mapper;

@Mapper(config = BaseMappingConfig.class)
public interface EnderecoMapper extends BaseMappingConfig<Endereco, EnderecoDTO>
{
}
