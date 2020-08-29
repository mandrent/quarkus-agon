package io.oneo.agon.modules.usuario.resource;

import io.oneo.agon.modules.usuario.model.Usuario;
import io.oneo.agon.modules.usuario.support.dto.UsuarioDTO;
import io.oneo.agon.modules.usuario.service.UsuarioService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;


@Path("/usuario")
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
        dto.setId(opt.get().id);
        return Response
                .ok(dto)
                .build();
    }

    @GET
    @Path("/{login}/login")
    public UsuarioDTO buscarLogin(@PathParam("login") String login)
    {
        Usuario usuario = this.service.buscarPorLogin(login);
        UsuarioDTO dto = this.service.convertOne(usuario, UsuarioDTO.class);
        return dto;
    }

    @GET
    @Path("/test")
    public List<Usuario> test()
    {


        return null;
    }

}