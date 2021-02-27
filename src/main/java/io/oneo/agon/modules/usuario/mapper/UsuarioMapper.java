package io.oneo.agon.modules.usuario.mapper;

import io.oneo.agon.modules.common.mapper.BaseMappingConfig;
import io.oneo.agon.modules.usuario.model.Usuario;
import io.oneo.agon.modules.usuario.resource.dto.UsuarioDTO;
import org.mapstruct.Mapper;

@Mapper(config = BaseMappingConfig.class)
public interface UsuarioMapper extends BaseMappingConfig<Usuario, UsuarioDTO>
{
}
