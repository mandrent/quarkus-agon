package io.oneo.agon.modules.endereco.mapper;

import io.oneo.agon.modules.common.mapper.BaseMapping;
import io.oneo.agon.modules.endereco.model.Endereco;
import io.oneo.agon.modules.endereco.resource.EnderecoDTO;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapping.class)
public interface EnderecoMapper extends BaseMapping<Endereco, EnderecoDTO>
{
}
