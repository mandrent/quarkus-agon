package io.oneo.agon.modules.telefone.client;


import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.telefone.resource.dto.TelefoneDTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.transaction.Transactional;
import javax.ws.rs.*;

@RegisterRestClient(baseUri = "http://localhost:8181/agon/telefones")
@Produces("application/json")
public interface TelefoneClient
{
    @GET
    @Path("/{id}")
    TelefoneDTO findByID(@PathParam("id") Long id);

    @POST
    TelefoneDTO create(@RequestBody TelefoneDTO dto) throws BaseServiceException;
}
