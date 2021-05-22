package io.oneo.agon.modules.cidade.mapper;

import io.oneo.agon.modules.common.mapper.BaseMapping;
import io.oneo.agon.modules.cidade.model.Cidade;
import io.oneo.agon.modules.cidade.resource.CidadeDTO;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapping.class)
public interface CidadeMapper extends BaseMapping<Cidade, CidadeDTO> { }