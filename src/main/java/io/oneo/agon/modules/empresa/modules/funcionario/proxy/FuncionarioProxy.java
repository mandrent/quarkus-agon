package io.oneo.agon.modules.empresa.modules.funcionario.proxy;

import io.oneo.agon.modules.empresa.modules.funcionario.exception.FuncionarioServiceException;
import io.oneo.agon.modules.empresa.modules.funcionario.resource.FuncionarioDTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;

@Produces("application/json")
@RegisterRestClient(configKey = "funcionarioProxy")
public interface FuncionarioProxy
{
    @GET
    @Path("/{id}")
    FuncionarioDTO findByID(@PathParam("id") Long id);

    @POST
    FuncionarioDTO create(@RequestBody FuncionarioDTO dto) throws FuncionarioServiceException;

    @POST
    @Path("/validate")
    FuncionarioDTO validate(@RequestBody FuncionarioDTO dto) throws FuncionarioServiceException;
}
