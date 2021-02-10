package io.oneo.agon.modules.empresa.modules.cargo.client;

import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.empresa.modules.cargo.resource.dto.CargoDTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@RegisterRestClient(baseUri = "http://localhost:8181/agon/empresas/cargos")
@Produces("application/json")
public interface CargoClient
{
    @GET
    @Path("/{id}")
    CargoDTO findByID(@PathParam("id") Long id);

    @POST
    CargoDTO create(@RequestBody CargoDTO dto) throws BaseServiceException;

}