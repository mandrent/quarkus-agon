package io.oneo.agon.modules.funcionario.resource;

import io.oneo.agon.modules.funcionario.model.Funcionario;
import io.oneo.agon.modules.funcionario.service.FuncionarioService;
import io.oneo.agon.modules.funcionario.support.dto.FuncionarioDTO;
import io.oneo.agon.modules.usuario.client.UsuarioClient;
import io.oneo.agon.modules.usuario.model.Usuario;
import io.oneo.agon.modules.usuario.support.dto.UsuarioDTO;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/funcionario")
@Produces("application/json")
@Consumes("application/json")
public class FuncionarioResource
{
    @Inject FuncionarioService service;

    @Inject
    @RestClient
    UsuarioClient usuarioClient;

    @GET
    public Response listar()
    {
        List<FuncionarioDTO> dtos = this.service.convertList(this.service.listar(), FuncionarioDTO.class);
        return Response
                .ok(dtos)
                .build();
    }

    @GET
    @Path("/login/{login}")
    public Response buscarUsuario(@PathParam("login") String login)
    {
        Usuario usuario = this.usuarioClient.buscarPorLogin(login);
        UsuarioDTO dto = this.service.convertOne(usuario, UsuarioDTO.class);
        return Response
                .ok(dto)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorID(@PathParam("matricula") String matricula)
    {
        return null;
    }



}