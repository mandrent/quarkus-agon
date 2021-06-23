package io.oneo.agon.modules.profissional.mapper;

import io.oneo.agon.modules.common.mapper.BaseMapping;
import io.oneo.agon.modules.profissional.model.Profissional;
import io.oneo.agon.modules.profissional.resource.dto.ProfissionalDTO;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapping.class)
public interface ProfissionalMapper extends BaseMapping<Profissional, ProfissionalDTO> { }