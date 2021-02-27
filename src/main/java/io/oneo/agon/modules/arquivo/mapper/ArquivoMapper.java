package io.oneo.agon.modules.arquivo.mapper;

import io.oneo.agon.modules.common.mapper.BaseMappingConfig;
import io.oneo.agon.modules.arquivo.model.Arquivo;
import io.oneo.agon.modules.arquivo.resource.dto.ArquivoDTO;
import org.mapstruct.Mapper;

@Mapper(config = BaseMappingConfig.class)
public interface ArquivoMapper extends BaseMappingConfig<Arquivo, ArquivoDTO> { }