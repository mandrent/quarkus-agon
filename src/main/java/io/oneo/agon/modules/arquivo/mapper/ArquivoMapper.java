package io.oneo.agon.modules.arquivo.mapper;

import io.oneo.agon.modules.common.mapper.BaseMapping;
import io.oneo.agon.modules.arquivo.model.Arquivo;
import io.oneo.agon.modules.arquivo.resource.ArquivoDTO;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapping.class)
public interface ArquivoMapper extends BaseMapping<Arquivo, ArquivoDTO>
{ }