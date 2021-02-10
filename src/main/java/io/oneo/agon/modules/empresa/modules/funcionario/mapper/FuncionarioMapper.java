package io.oneo.agon.modules.empresa.modules.funcionario.mapper;

import io.oneo.agon.infra.mapper.BaseMappingConfig;
import io.oneo.agon.modules.empresa.modules.funcionario.model.Funcionario;
import io.oneo.agon.modules.empresa.modules.funcionario.resource.FuncionarioDTO;
import org.mapstruct.Mapper;

@Mapper(config = BaseMappingConfig.class)
public interface FuncionarioMapper extends BaseMappingConfig<Funcionario, FuncionarioDTO> { }