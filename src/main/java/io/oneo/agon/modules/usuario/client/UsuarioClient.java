package io.oneo.agon.modules.usuario.client;

import io.oneo.agon.modules.usuario.model.Usuario;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/usuario-client")
@RegisterRestClient
public interface UsuarioClient
{

    @GET
    @Path("/login/{login}")
    @Produces("application/json")
    Usuario buscarPorLogin(@PathParam("login") String login);

}