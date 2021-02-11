package io.oneo.agon.modules.profissional.api;


import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.profissional.resource.dto.ProfissionalDTO;
import io.oneo.agon.modules.profissional.service.ProfissionalService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("profissionais")
@Produces("application/json")
@Consumes("application/json")
public class ProfissionalResource
{
    @Inject ProfissionalService service;

    @GET
    @Operation(description = "Lista os profissionais")
    @Tag(name="profissionais")
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
    @Operation(description = "Busca profissional por ID")
    @Tag(name="profissionais")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByID(@PathParam("id") Long id)
    {
        var profissional= this.service.findByID(id);
        var dto = this.service.getMapper().convertToDTO(profissional.get());
        return Response
                .ok(dto)
                .build();
    }

    @POST
    @Operation(description = "Cadastra novo profissional")
    @Tag(name="profissionais")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response create(@RequestBody ProfissionalDTO dto) throws BaseServiceException
    {
        var profissional = this.service.getMapper().convertToModel(dto);
        this.service.addEdit(profissional);
        dto = this.service.getMapper().convertToDTO(profissional);
        return Response
                .ok(dto)
                .build();
    }

    @PUT
    @Operation(description = "Atualiza os dados do profissional")
    @Tag(name="profissionais")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response update(@RequestBody ProfissionalDTO dto) throws BaseServiceException
    {
        var profissional= this.service.getMapper().convertToModel(dto);
        this.service.addEdit(profissional);
        dto = this.service.getMapper().convertToDTO(profissional);
        return Response
                .ok(dto)
                .build();
    }


}