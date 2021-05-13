package io.oneo.agon.modules.usuario.mapper;

import io.oneo.agon.modules.common.mapper.BaseMapping;
import io.oneo.agon.modules.usuario.model.Usuario;
import io.oneo.agon.modules.usuario.resource.dto.UsuarioDTO;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapping.class)
public interface UsuarioMapper extends BaseMapping<Usuario, UsuarioDTO>
{ }