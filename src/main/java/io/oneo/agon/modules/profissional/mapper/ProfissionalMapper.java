package io.oneo.agon.modules.profissional.mapper;

import io.oneo.agon.infra.mapper.BaseMappingConfig;
import io.oneo.agon.modules.profissional.model.Profissional;
import io.oneo.agon.modules.profissional.resource.dto.ProfissionalDTO;
import org.mapstruct.Mapper;

@Mapper(config = BaseMappingConfig.class)
public interface ProfissionalMapper extends BaseMappingConfig<Profissional, ProfissionalDTO> { }
