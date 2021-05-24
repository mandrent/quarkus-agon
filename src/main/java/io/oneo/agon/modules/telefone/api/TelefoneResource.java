package io.oneo.agon.modules.telefone.api;

import io.oneo.agon.modules.telefone.exception.TelefoneServiceException;
import io.oneo.agon.modules.telefone.resource.dto.TelefoneDTO;
import io.oneo.agon.modules.telefone.service.TelefoneService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/api/telefones")
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
        return Response
                .ok(this.service.mapper().dtoList(list))
                .build();
    }

    @GET
    @Path("/{id}")
    @Operation(description = "Busca telefone por ID")
    @Tag(name="telefones")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByID(@PathParam("id") Long id)
    {
        var telefone = this.service.findByID(id);
        if (!telefone.isPresent())
        {
            return Response
                    .noContent()
                    .build();
        }
        return Response
                .ok(this.service.mapper().getDTO(telefone.get()))
                .build();
    }

    @GET
    @Path("/numero/{numero}")
    @Operation(description = "Busca por numero")
    @Tag(name="telefones")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByNumber(@PathParam("numero") String numero)
    {
        var telefone = this.service.findByNumber(numero);
        if (!telefone.isPresent())
        {
            return Response
                    .noContent()
                    .build();
        }
        return Response
                .ok(this.service.mapper().getDTO(telefone.get()))
                .build();
    }

    @POST
    @Operation(description = "Cadastra novo telefone")
    @Tag(name="telefones")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response create(@RequestBody TelefoneDTO dto) throws TelefoneServiceException
    {
        var telefone = this.service.mapper().getModel(dto);
        this.service.addEdit(telefone);
        return Response
                .ok(this.service.mapper().getDTO(telefone))
                .build();
    }

    @POST
    @Path("/validate")
    @Operation(description = "Valida o TelefoneProxy")
    @Tag(name="telefones")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response validate(@RequestBody TelefoneDTO dto) throws TelefoneServiceException
    {
        var telefone = this.service.validate(this.service.mapper().getModel(dto));
        if (telefone.isPresent())
        {
            return Response
                    .ok(this.service.mapper().getDTO(telefone.get()))
                    .build();
        }
        return this.create(dto);
    }

    @PUT
    @Operation(description = "Atualiza os dados do telefone")
    @Tag(name="telefones")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response update(@RequestBody TelefoneDTO dto) throws TelefoneServiceException
    {
        var telefone= this.service.mapper().getModel(dto);
        this.service.addEdit(telefone);
        dto = this.service.mapper().getDTO(telefone);
        return Response
                .ok(dto)
                .build();
    }

}