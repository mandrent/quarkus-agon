package io.oneo.agon.modules.usuario.resource;

import io.oneo.agon.modules.usuario.model.Usuario;
import io.oneo.agon.modules.usuario.service.UsuarioService;
import io.oneo.agon.modules.usuario.support.dto.UsuarioDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/usuarios")
@Produces("application/json")
@Consumes("application/json")
public class UsuarioResource
{
    @Inject UsuarioService service;

    @GET
    public Response listar()
    {
        List<Usuario> list = this.service.listar();
        List<UsuarioDTO> dtos = this.service.convertList(list, UsuarioDTO.class);
        return Response
                .ok(dtos)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorID(@PathParam("id") Long id)
    {
        Optional<Usuario> opt = this.service.buscarPorID(id);
        UsuarioDTO dto = this.service.convertOne(opt.get(), UsuarioDTO.class);
        if (dto.getId() == null)
        {
            dto.setId(opt.get().id);
        }
        return Response
                .ok(dto)
                .build();
    }

    @GET
    @Path("/{login}/login")
    public Response findByLogin(@PathParam("login") String login)
    {
        Optional<Usuario> usuario = this.service.findByLogin(login);
        if (!usuario.isPresent())
        {
            return Response
                    .noContent()
                    .build();
        }
        UsuarioDTO dto = this.service.convertOne(usuario.get(), UsuarioDTO.class);
        if (dto.getId() == null)
        {
            dto.setId(usuario.get().id);
        }
        return Response
                .ok(dto)
                .build();
    }

}