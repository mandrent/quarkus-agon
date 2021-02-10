package io.oneo.agon.modules.telefone.api;

import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.telefone.model.Telefone;
import io.oneo.agon.modules.telefone.resource.dto.TelefoneDTO;
import io.oneo.agon.modules.telefone.service.TelefoneService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("telefones")
@Produces("application/json")
@Consumes("application/json")
public class TelefoneResource
{
    @Inject TelefoneService service;

    @GET
    @Operation(description = "Lista os telefones")
    @Tag(name="telefones")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response list()
    {
        var list = this.service.list();
        var dtoList = this.service.getMapper().convertToDtoList(list);
//                .convertToDtoList(list);
        return Response
                .ok(dtoList)
                .build();
    }
    @GET
    @Path("/{id}")
    @Operation(description = "Busca telefone por ID")
    @Tag(name="telefones")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByID(@PathParam("id") Long id)
    {
        var cargo = this.service.findByID(id);
        var dto = this.service.getMapper().convertToDTO(cargo.get());
        return Response
                .ok(dto)
                .build();
    }

    @GET
    @Path("/numero/{numero}")
    @Operation(description = "Busca por numero")
    @Tag(name="telefones")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByName(@PathParam("numero") String numero)
    {
        var telefone = this.service.findByNumber(numero);
        if (telefone.isPresent())
        {
            var dto = this.service.getMapper().convertToDTO(telefone.get());
            return Response
                    .ok(dto)
                    .build();
        }
        return Response
                .noContent()
                .build();
    }

    @POST
    @Operation(description = "Cadastra novo telefone")
    @Tag(name="telefones")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response create(@RequestBody TelefoneDTO dto) throws BaseServiceException
    {
        var telefone = this.service.getMapper().convertToModel(dto);
        this.service.addEdit(telefone);
        dto = this.service.getMapper().convertToDTO(telefone);
        return Response
                .ok(dto)
                .build();
    }

    @PUT
    @Operation(description = "Atualiza os dados do telefone")
    @Tag(name="telefones")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response update(@RequestBody TelefoneDTO dto) throws BaseServiceException
    {
        var telefone= this.service.getMapper().convertToModel(dto);
        this.service.addEdit(telefone);
        dto = this.service.getMapper().convertToDTO(telefone);
        return Response
                .ok(dto)
                .build();
    }




}
