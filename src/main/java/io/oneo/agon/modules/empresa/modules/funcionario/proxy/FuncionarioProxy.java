package io.oneo.agon.modules.empresa.modules.funcionario.proxy;

import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.empresa.modules.funcionario.resource.FuncionarioDTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;

@RegisterRestClient(baseUri = "http://localhost:8181/agon/empresas/funcionarios")
@Produces("application/json")
public interface FuncionarioProxy
{
    @GET
    @Path("/{id}")
    FuncionarioDTO findByID(@PathParam("id") Long id);

    @POST
    FuncionarioDTO create(@RequestBody FuncionarioDTO dto) throws BaseServiceException;

    @POST
    @Path("/validate")
    FuncionarioDTO validate(@RequestBody FuncionarioDTO dto) throws BaseServiceException;
}