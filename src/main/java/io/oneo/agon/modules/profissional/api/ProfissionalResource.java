package io.oneo.agon.modules.profissional.api;

import io.oneo.agon.modules.profissional.exception.ProfissionalServiceException;
import io.oneo.agon.modules.profissional.resource.dto.ProfissionalDTO;
import io.oneo.agon.modules.profissional.service.ProfissionalService;
import io.oneo.agon.modules.telefone.proxy.TelefoneProxy;
import io.oneo.agon.modules.usuario.proxy.UsuarioProxy;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/api/profissionais")
@Produces("application/json")
@Consumes("application/json")
public class ProfissionalResource
{
    @Inject ProfissionalService service;

    @Inject
    @RestClient
    UsuarioProxy usuarioProxy;

    @Inject
    @RestClient
    TelefoneProxy telefoneProxy;

    @GET
    @Operation(description = "Lista os profissionais")
    @Tag(name="profissionais")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response list()
    {
        return Response
                .ok(this.service.getMapper().dtoList(this.service.list()))
                .build();
    }

    @GET
    @Path("/{id}")
    @Operation(description = "Busca profissional por ID")
    @Tag(name="profissionais")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByID(@PathParam("id") Long id)
    {
        var profissional = this.service.findByID(id);
        return Response
                .ok(this.service.getMapper().getDTO(profissional.get()))
                .build();
    }

    @PUT
    @Path("/documents")
    @Operation(description = "Busca por documentos")
    @Tag(name="profissionais")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByDocuments(@RequestBody ProfissionalDTO dto)
    {
        var profissional = this.service.findByDocuments(this.service.getMapper().getModel(dto));
        return Response
                .ok(this.service.getMapper().getDTO(profissional.get()))
                .build();
    }

    @POST
    @Operation(description = "Adiciona novo profissional")
    @Tag(name="profissionais")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response create(@RequestBody ProfissionalDTO dto) throws ProfissionalServiceException
    {
        dto.usuario = this.usuarioProxy.validate(dto.usuario);
        dto.telefone = this.telefoneProxy.validate(dto.telefone);
        var profissional = this.service.getMapper().getModel(dto);
        this.service.addEdit(profissional);
        return Response
                .ok(this.service.getMapper().getDTO(profissional))
                .build();
    }

    @POST
    @Path("/validate")
    @Operation(description = "Valida o usuario")
    @Tag(name="profissionais")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response validate(@RequestBody ProfissionalDTO dto) throws ProfissionalServiceException
    {
        var profissional = this.service.validate(this.service.getMapper().getModel(dto));
        if (profissional.isPresent())
        {
            return Response
                    .ok(this.service.getMapper().getDTO(profissional.get()))
                    .build();
        }
        return this.create(dto);
    }

}