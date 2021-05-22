package io.oneo.agon.modules.endereco.api;

import io.oneo.agon.modules.endereco.exception.EnderecoServiceException;
import io.oneo.agon.modules.endereco.resource.EnderecoDTO;
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
        var list = this.service.list();
        return Response
                .ok(this.service.mapper().dtoList(list))
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
        if (!endereco.isPresent())
        {
            return Response
                    .noContent()
                    .build();
        }
        return Response
                .ok(this.service.mapper().getDTO(endereco.get()))
                .build();
    }

    @POST
    @Operation(description = "Cadastra novo endereco")
    @Tag(name="enderecos")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response create(@RequestBody EnderecoDTO dto) throws EnderecoServiceException
    {
        var endereco = this.service.mapper().getModel(dto);
        this.service.addEdit(endereco);
        return Response
                .ok(this.service.mapper().getDTO(endereco))
                .build();
    }

    @POST
    @Path("/validate")
    @Operation(description = "Valida o Endereco")
    @Tag(name="enderecos")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response validate(@RequestBody EnderecoDTO dto) throws EnderecoServiceException
    {
        var endereco = this.service.validate(this.service.mapper().getModel(dto));
        if (endereco.isPresent())
        {
            return Response
                    .ok(this.service.mapper().getDTO(endereco.get()))
                    .build();
        }
        return this.create(dto);
    }

    @PUT
    @Operation(description = "Atualiza os dados do endereco")
    @Tag(name="enderecos")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response update(@RequestBody EnderecoDTO dto) throws EnderecoServiceException
    {
        var endereco= this.service.mapper().getModel(dto);
        this.service.addEdit(endereco);
        return Response
                .ok(this.service.mapper().getDTO(endereco))
                .build();
    }


}