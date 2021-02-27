package io.oneo.agon.modules.profissional.api;

import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.profissional.resource.dto.ProfissionalDTO;
import io.oneo.agon.modules.profissional.service.ProfissionalService;
import io.oneo.agon.modules.telefone.proxy.TelefoneProxy;
import io.oneo.agon.modules.usuario.proxy.UsuarioClient;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("profissionais")
@Produces("application/json")
@Consumes("application/json")
public class ProfissionalResource
{
    @Inject ProfissionalService service;

    @Inject
    @RestClient
    UsuarioClient usuarioClient;

    @Inject
    @RestClient
    TelefoneProxy telefoneProxy;

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
        var profissional = this.service.findByID(id);
        if (!profissional.isPresent())
        {
            return Response
                    .noContent()
                    .build();
        }
        var dto = this.service.getMapper().convertToDTO(profissional.get());
        return Response
                .ok(dto)
                .build();
    }

    @POST
    @Operation(description = "Adiciona novo profissional")
    @Tag(name="profissionais")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response create(@RequestBody ProfissionalDTO dto) throws BaseServiceException
    {
        dto.usuario = this.usuarioClient.validate(dto.usuario);
        dto.telefone = this.telefoneProxy.validate(dto.telefone);
        var profissional = this.service.getMapper().convertToModel(dto);
        this.service.addEdit(profissional);
        dto = this.service.getMapper().convertToDTO(profissional);
        return Response
                .ok(dto)
                .build();
    }

    @POST
    @Path("/validate")
    @Operation(description = "Valida o usuario")
    @Tag(name="profissionais")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response validate(@RequestBody ProfissionalDTO dto) throws BaseServiceException
    {
        if (dto.id != null)
        {
            return this.findByID(dto.id);
        }
        return this.create(dto);
    }

}