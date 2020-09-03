package io.oneo.agon.modules.usuario.client;

import io.oneo.agon.modules.usuario.model.Usuario;
import io.oneo.agon.modules.usuario.support.dto.UsuarioDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/usuario")
@RegisterRestClient(configKey = "usuario-api")
public interface UsuarioClient
{

    @GET
    @Path("/login/{login}")
    @Produces("application/json")
    UsuarioDTO getByName(@PathParam("login") String login);

}