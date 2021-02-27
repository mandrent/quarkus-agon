package io.oneo.agon.modules.endereco.api;

import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.endereco.model.Endereco;
import io.oneo.agon.modules.endereco.resource.dto.EnderecoDTO;
import io.oneo.agon.modules.endereco.service.EnderecoService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("enderecos")
@Produces("application/json")
@Consumes("application/json")
public class EnderecoResource
{
    @Inject EnderecoService service;

    @GET
    @Operation(description = "Lista os enderecos")
    @Tag(name="enderecos")
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
    @Operation(description = "Busca endereco por ID")
    @Tag(name="enderecos")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByID(@PathParam("id") Long id)
    {
        var endereco = this.service.findByID(id);
        var dto = this.service.getMapper().convertToDTO(endereco.get());
        return Response
                .ok(dto)
                .build();
    }

    @POST
    @Operation(description = "Cadastra novo endereco")
    @Tag(name="enderecos")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response create(@RequestBody EnderecoDTO dto) throws BaseServiceException
    {
        var endereco = this.service.getMapper().convertToModel(dto);
        this.service.addEdit(endereco);
        dto = this.service.getMapper().convertToDTO(endereco);
        return Response
                .ok(dto)
                .build();
    }

    @POST
    @Path("/validate")
    @Operation(description = "Valida o Endereco")
    @Tag(name="enderecos")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response validate(@RequestBody EnderecoDTO dto) throws BaseServiceException
    {
        if (dto.id != null)
        {
            return this.findByID(dto.id);
        }
        return this.create(dto);
    }

    @PUT
    @Operation(description = "Atualiza os dados do endereco")
    @Tag(name="enderecos")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response update(@RequestBody EnderecoDTO dto) throws BaseServiceException
    {
        var endereco= this.service.getMapper().convertToModel(dto);
        this.service.addEdit(endereco);
        dto = this.service.getMapper().convertToDTO(endereco);
        return Response
                .ok(dto)
                .build();
    }


}