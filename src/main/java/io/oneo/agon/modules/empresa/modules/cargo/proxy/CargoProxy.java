package io.oneo.agon.modules.empresa.modules.cargo.proxy;

import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.empresa.modules.cargo.resource.dto.CargoDTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;

@Produces("application/json")
@RegisterRestClient(configKey = "cargoProxy")
public interface CargoProxy
{
    @GET
    @Path("/{id}")
    CargoDTO findByID(@PathParam("id") Long id);

    @POST
    CargoDTO create(@RequestBody CargoDTO dto) throws BaseServiceException;

    @POST
    @Path("/validate")
    CargoDTO validate(@RequestBody CargoDTO dto) throws BaseServiceException;
}