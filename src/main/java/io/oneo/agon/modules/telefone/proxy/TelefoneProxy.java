package io.oneo.agon.modules.telefone.proxy;


import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.telefone.resource.dto.TelefoneDTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;

@Produces("application/json")
@RegisterRestClient(configKey = "telefoneProxy")
public interface TelefoneProxy
{
    @GET
    @Path("/{id}")
    TelefoneDTO findByID(@PathParam("id") Long id);

    @POST
    TelefoneDTO create(@RequestBody TelefoneDTO dto) throws BaseServiceException;

    @POST
    @Path("/validate")
    TelefoneDTO validate(@RequestBody TelefoneDTO dto) throws BaseServiceException;
}
