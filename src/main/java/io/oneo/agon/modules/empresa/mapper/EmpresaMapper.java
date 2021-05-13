package io.oneo.agon.modules.empresa.mapper;

import io.oneo.agon.modules.common.mapper.BaseMapping;
import io.oneo.agon.modules.empresa.model.Empresa;
import io.oneo.agon.modules.empresa.resource.EmpresaDTO;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapping.class)
public interface EmpresaMapper extends BaseMapping<Empresa, EmpresaDTO>
{

}