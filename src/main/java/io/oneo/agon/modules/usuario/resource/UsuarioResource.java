package io.oneo.agon.modules.usuario.resource;

import io.oneo.agon.modules.usuario.client.UsuarioClient;
import io.oneo.agon.modules.usuario.model.Usuario;
import io.oneo.agon.modules.usuario.service.UsuarioService;
import io.oneo.agon.modules.usuario.support.dto.UsuarioDTO;
import org.eclipse.microprofile.rest.client.inject.RestClient;

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

    @Inject
    @RestClient
    UsuarioClient client;

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
    @Path("findByLoginLocal")
    public Response findByLogin(@PathParam("login") String login)
    {
        Usuario usuario = this.client.findByLogin(login);
        UsuarioDTO dto = this.service.convertOne(usuario, UsuarioDTO.class);
        return Response
                .ok(dto)
                .build();
    }

//    public Response buscarPorLogin(@PathParam("login") String login)
//    findByLogin(@QueryParam("login") String login);

    @GET
    @Path("/test")
    public List<Usuario> test()
    {


        return null;
    }

}