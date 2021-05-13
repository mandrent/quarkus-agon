package io.oneo.agon.modules.endereco.proxy;

import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.endereco.resource.dto.EnderecoDTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;

@Produces("application/json")
@RegisterRestClient(configKey = "enderecoProxy")
public interface EnderecoProxy
{
    @GET
    @Path("/{id}")
    EnderecoDTO findByID(@PathParam("id") Long id);

    @POST
    EnderecoDTO create(@RequestBody EnderecoDTO dto) throws BaseServiceException;

    @POST
    @Path("/validate")
    EnderecoDTO validate(@RequestBody EnderecoDTO dto) throws BaseServiceException;
}