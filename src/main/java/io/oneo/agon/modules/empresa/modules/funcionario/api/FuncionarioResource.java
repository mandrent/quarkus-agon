package io.oneo.agon.modules.empresa.modules.funcionario.api;

import io.oneo.agon.modules.empresa.modules.cargo.proxy.CargoProxy;
import io.oneo.agon.modules.empresa.modules.funcionario.exception.FuncionarioServiceException;
import io.oneo.agon.modules.empresa.modules.funcionario.resource.FuncionarioDTO;
import io.oneo.agon.modules.empresa.modules.funcionario.service.FuncionarioService;
import io.oneo.agon.modules.endereco.proxy.EnderecoProxy;
import io.oneo.agon.modules.telefone.proxy.TelefoneProxy;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("empresas/funcionarios")
@Produces("application/json")
@Consumes("application/json")
public class FuncionarioResource
{
    @Inject FuncionarioService service;

    @Inject
    @RestClient
    CargoProxy cargoProxy;

    @Inject
    @RestClient
    TelefoneProxy telefoneProxy;

    @Inject
    @RestClient
    EnderecoProxy enderecoProxy;

    @POST
    @Operation(description = "Cadastra um novo funcionário")
    @Tag(name="funcionarios")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response create(@RequestBody FuncionarioDTO dto) throws FuncionarioServiceException
    {
        dto.cargo = this.cargoProxy.validate(dto.cargo);
        dto.telefone = this.telefoneProxy.validate(dto.telefone);
        dto.endereco = this.enderecoProxy.validate(dto.endereco);
        var funcionario = this.service.getMapper().getModel(dto);
        this.service.addEdit(funcionario);
        dto = this.service.getMapper().getDTO(funcionario);
        return Response
                .ok(dto)
                .build();
    }

    @GET
    @Operation(description = "Lista todos os funcionários")
    @Tag(name="funcionarios")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response list()
    {
        var list = this.service.getMapper().dtoList(this.service.list());
        return Response
                .ok(list)
                .build();
    }

    @GET
    @Path("/{id}")
    @Operation(description = "Busca o usuário pelo ID")
    @Tag(name="funcionarios")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByID(@PathParam("id") Long id)
    {
        var funcionario = this.service.findByID(id).get();
        var dto = this.service.getMapper().getDTO(funcionario);
        return Response
                .ok(dto)
                .build();
    }


}