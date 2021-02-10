package io.oneo.agon.modules.empresa.mapper;

import io.oneo.agon.infra.mapper.BaseMappingConfig;
import io.oneo.agon.modules.empresa.model.Empresa;
import io.oneo.agon.modules.empresa.resource.dto.EmpresaDTO;
import org.mapstruct.Mapper;

@Mapper(config = BaseMappingConfig.class)
public interface EmpresaMapper extends BaseMappingConfig<Empresa, EmpresaDTO>
{

}