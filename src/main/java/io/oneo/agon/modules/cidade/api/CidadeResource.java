package io.oneo.agon.modules.cidade.api;

import io.oneo.agon.modules.cidade.service.CidadeService;
import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.cidade.resource.dto.CidadeDTO;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("cidades")
@Produces("application/json")
@Consumes("application/json")
public class CidadeResource
{
    @Inject CidadeService service;
    
    @GET
    @Operation(description = "Lista todas as cidades")
    @Tag(name="cidades")
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
    @Operation(description = "Busca cidade por ID")
    @Tag(name="cidades")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByID(@PathParam("id") Long id)
    {
        var cidade = this.service.findByID(id);
        if (!cidade.isPresent())
        {
            return Response
                    .noContent()
                    .build();
        }
        var dto = this.service.getMapper().convertToDTO(cidade.get());
        return Response
                .ok(dto)
                .build();
    }
    
    @GET
    @Path("/{code}")
    @Operation(description = "Busca cidade por codigo")
    @Tag(name="cidades")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByCode(@PathParam("code") String code)
    {
        var cidade = this.service.findByCode(code);
        if (!cidade.isPresent())
        {
            return Response
                    .noContent()
                    .build();
        }
        var dto = this.service.getMapper().convertToDTO(cidade.get());
        return Response
                .ok(dto)
                .build();
    }

    @POST
    @Operation(description = "Adiciona novo cidade")
    @Tag(name="cidades")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response create(@RequestBody CidadeDTO dto) throws BaseServiceException
    {
        var cidade = this.service.getMapper().convertToModel(dto);
        this.service.addEdit(cidade);
        dto = this.service.getMapper().convertToDTO(cidade);
        return Response
                .ok(dto)
                .build();
    }

    @POST
    @Path("/validate")
    @Operation(description = "Valida a cidade")
    @Tag(name="cidades")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response validate(@RequestBody CidadeDTO dto) throws BaseServiceException
    {
        if (dto.id != null)
        {
            return this.findByID(dto.id);
        }
        return this.create(dto);
    }
}