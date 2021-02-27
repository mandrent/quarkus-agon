package io.oneo.agon.modules.empresa.api;

import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.empresa.resource.dto.EmpresaDTO;
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
        var list = this.service.getMapper().convertToDtoList(this.service.list());
        return Response
                .ok(list)
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
        var dto = this.service.getMapper().convertToDTO(empresa.get());
        return Response
                .ok(dto)
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

        var dto = this.service.getMapper().convertToDTO(empresa.get());
        return Response
                .ok(dto)
                .build();
    }

    @POST
    @Operation(description = "Cadastra um novo usuário")
    @Tag(name="empresas")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response create(@RequestBody EmpresaDTO dto) throws BaseServiceException
    {
        dto.endereco = this.enderecoProxy.validate(dto.endereco);
        dto.telefone = this.telefoneProxy.validate(dto.telefone);
        var empresa = this.service.getMapper().convertToModel(dto);
        this.service.addEdit(empresa);
        dto = this.service.getMapper().convertToDTO(empresa);
        return Response
                .ok(dto)
                .build();
    }
    
    @POST
    @Path("/validate")
    @Operation(description = "Valida usuário")
    @Tag(name="empresas")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response validate(@RequestBody EmpresaDTO dto) throws BaseServiceException
    {
        if (dto.id != null)
        {
            return this.findByID(dto.id);
        }
        return this.create(dto);
    }

    @PUT
    @Operation(description = "Atualiza os dados do usuário")
    @Tag(name="empresas")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response update(@RequestBody EmpresaDTO dto) throws BaseServiceException
    {
        var empresa = this.service.getMapper().convertToModel(dto);
        this.service.addEdit(empresa);
        dto = this.service.getMapper().convertToDTO(empresa);
        return Response
                .ok(dto)
                .build();
    }

}