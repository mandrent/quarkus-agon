package io.oneo.agon.modules.acesso.modules.usuario.rest;

import io.oneo.agon.modules.acesso.modules.usuario.model.Usuario;
import io.oneo.agon.modules.acesso.modules.usuario.resource.UsuarioDTO;
import io.oneo.agon.modules.acesso.modules.usuario.service.UsuarioService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.Optional;


@Path("/usuario")
@Produces("application/json")
@Consumes("application/json")
public class UsuarioResource
{
    @Inject private UsuarioService service;

    @GET
    public List<UsuarioDTO> listar()
    {
        List<Usuario> list = this.service.listar();
        List<UsuarioDTO> dtos = this.service.convertList(list, UsuarioDTO.class);
        return dtos;
    }

    @GET
    @Path("/{id}")
    public UsuarioDTO buscarPorID(@PathParam("id") Long id)
    {
        Optional<Usuario> opt = this.service.buscarPorID(id);
        UsuarioDTO dto = this.service.convertOne(opt.get(), UsuarioDTO.class);
        return dto;
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