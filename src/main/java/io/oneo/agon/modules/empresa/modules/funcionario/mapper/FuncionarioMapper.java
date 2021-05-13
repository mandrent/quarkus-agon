package io.oneo.agon.modules.empresa.modules.funcionario.mapper;

import io.oneo.agon.modules.common.mapper.BaseMapping;
import io.oneo.agon.modules.empresa.modules.funcionario.model.Funcionario;
import io.oneo.agon.modules.empresa.modules.funcionario.resource.FuncionarioDTO;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapping.class)
public interface FuncionarioMapper extends BaseMapping<Funcionario, FuncionarioDTO>
{
}
