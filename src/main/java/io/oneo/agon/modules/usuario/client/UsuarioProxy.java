package io.oneo.agon.modules.usuario.client;

import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.usuario.resource.dto.UsuarioDTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;

@RegisterRestClient(baseUri = "http://localhost:8181/agon/usuarios")
@Produces("application/json")
public interface UsuarioProxy
{
    @GET
    @Path("/{id}")
    UsuarioDTO findByID(@PathParam("id") Long id);

    @POST
    UsuarioDTO create(@RequestBody UsuarioDTO dto) throws BaseServiceException;

    @POST
    @Path("/validate")
    UsuarioDTO validate(@RequestBody UsuarioDTO dto) throws BaseServiceException;
}