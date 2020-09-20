package io.oneo.agon.modules.usuario.client;

import io.oneo.agon.modules.usuario.model.Usuario;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;

@Path("/usuario")
@RegisterRestClient
@Produces("application/json")
public interface UsuarioClient
{

    @GET
    @Path("findByLogin")
    Usuario findByLogin(@PathParam("login") String login);

}