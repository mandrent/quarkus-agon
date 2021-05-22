package io.oneo.agon.modules.cidade.api;

import io.oneo.agon.modules.cidade.exception.CidadeServiceException;
import io.oneo.agon.modules.cidade.service.CidadeService;
import io.oneo.agon.modules.cidade.resource.CidadeDTO;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/api/cidades")
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
        var list = this.service.list();
        return Response
                .ok(this.service.mapper().dtoList(list))
                .build();
    }

    @GET
    @Path("/{id}")
    @Operation(description = "Busca por ID")
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
        return Response
                .ok(this.service.mapper().getDTO(cidade.get()))
                .build();
    }
    
    @GET
    @Path("/codigo/{code}")
    @Operation(description = "Busca por codigo")
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
        return Response
                .ok(this.service.mapper().getDTO(cidade.get()))
                .build();
    }

    @GET
    @Path("/name/{name}")
    @Operation(description = "Busca por codigo")
    @Tag(name="cidades")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByName(@PathParam("name") String code)
    {
        var cidade = this.service.findByName(code);
        if (!cidade.isPresent())
        {
            return Response
                    .noContent()
                    .build();
        }
        return Response
                .ok(this.service.mapper().getDTO(cidade.get()))
                .build();
    }

    @POST
    @Path("/validate")
    @Operation(description = "Valida a cidade")
    @Tag(name="cidades")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response validate(@RequestBody CidadeDTO dto) throws CidadeServiceException
    {
        var cidade = this.service.validate(this.service.mapper().getModel(dto));
        if (!cidade.isPresent())
        {
            return Response
                    .noContent()
                    .build();
        }
        return Response
                .ok(this.service.mapper().getDTO(cidade.get()))
                .build();
    }
}