package io.oneo.agon.modules.telefone.mapper;

import io.oneo.agon.modules.common.mapper.BaseMapping;
import io.oneo.agon.modules.telefone.model.Telefone;
import io.oneo.agon.modules.telefone.resource.TelefoneDTO;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapping.class)
public interface TelefoneMapper extends BaseMapping<Telefone, TelefoneDTO> { }