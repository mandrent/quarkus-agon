package io.oneo.agon.modules.cidade.mapper;

import io.oneo.agon.modules.common.mapper.BaseMappingConfig;
import io.oneo.agon.modules.cidade.model.Cidade;
import io.oneo.agon.modules.cidade.resource.dto.CidadeDTO;
import org.mapstruct.Mapper;

@Mapper(config = BaseMappingConfig.class)
public interface CidadeMapper extends BaseMappingConfig<Cidade, CidadeDTO> { }