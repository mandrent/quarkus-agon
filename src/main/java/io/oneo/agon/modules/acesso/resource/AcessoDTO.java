package io.oneo.agon.modules.acesso.resource;

import io.oneo.agon.modules.acesso.modules.usuario.resource.GrupoDTO;
import io.oneo.agon.modules.acesso.modules.usuario.resource.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AcessoDTO implements Serializable
{
    private static final long serialVersionUID = -6982780234649259067L;
    
    private List<UsuarioDTO> usuarios;
    
    private List<GrupoDTO> grupos;

    private int adc;

    private int edt;

    private int rmv;

    private int viw;

    private int spc;
}