package io.oneo.agon.modules.empresa.api;

import io.oneo.agon.modules.empresa.exception.EmpresaServiceException;
import io.oneo.agon.modules.empresa.resource.EmpresaDTO;
import io.oneo.agon.modules.empresa.service.EmpresaService;
import io.oneo.agon.modules.endereco.proxy.EnderecoProxy;
import io.oneo.agon.modules.telefone.proxy.TelefoneProxy;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("empresas")
@Produces("application/json")
@Consumes("application/json")
public class EmpresaResource
{
    @Inject EmpresaService service;

    @Inject
    @RestClient
    EnderecoProxy enderecoProxy;

    @Inject
    @RestClient
    TelefoneProxy telefoneProxy;

    @GET
    @Operation(description = "Lista Empresa")
    @Tag(name="empresas")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response list()
    {
        var list = this.service.list();
        return Response
                .ok(this.service.mapper().dtoList(list))
                .build();
    }

    @GET
    @Path("/{id}")
    @Operation(description = "Buscar usuário pelo ID")
    @Tag(name="empresas")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByID(@PathParam("id") Long id)
    {
        var empresa = this.service.findByID(id);
        if (!empresa.isPresent())
        {
            return Response
                    .noContent()
                    .build();
        }
        return Response
                .ok(this.service.mapper().getDTO(empresa.get()))
                .build();
    }

    @GET
    @Path("/cnpj/{cnpj}")
    @Operation(description = "Busca empresa pelo CNPJ")
    @Tag(name="empresas")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByCNPJ(@PathParam("cnpj") String cnpj)
    {
        var empresa = this.service.findByCNPJ(cnpj);
        if (!empresa.isPresent())
        {
            return Response
                    .noContent()
                    .build();
        }
        return Response
                .ok(this.service.mapper().getDTO(empresa.get()))
                .build();
    }

    @POST
    @Operation(description = "Cadastra um novo usuário")
    @Tag(name="empresas")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response create(@RequestBody EmpresaDTO dto) throws EmpresaServiceException
    {
        dto.endereco = this.enderecoProxy.validate(dto.endereco);
        dto.telefone = this.telefoneProxy.validate(dto.telefone);
        var empresa = this.service.mapper().getModel(dto);
        this.service.addEdit(empresa);
        return Response
                .ok(this.service.mapper().getDTO(empresa))
                .build();
    }
    
    @POST
    @Path("/validate")
    @Operation(description = "Valida usuário")
    @Tag(name="empresas")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response validate(@RequestBody EmpresaDTO dto) throws EmpresaServiceException
    {
        var empresa = this.service.validate(this.service.mapper().getModel(dto));
        if (!empresa.isPresent())
        {
            return Response
                    .noContent()
                    .build();
        }
        return this.create(dto);
    }

    @PUT
    @Operation(description = "Atualiza os dados do usuário")
    @Tag(name="empresas")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response update(@RequestBody EmpresaDTO dto) throws EmpresaServiceException
    {
        var empresa = this.service.mapper().getModel(dto);
        this.service.addEdit(empresa);
        return Response
                .ok(this.service.mapper().getDTO(empresa))
                .build();
    }

}