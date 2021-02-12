package io.oneo.agon.modules.usuario.api;

import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.usuario.model.Usuario;
import io.oneo.agon.modules.usuario.resource.dto.UsuarioDTO;
import io.oneo.agon.modules.usuario.service.UsuarioService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("usuarios")
@Produces("application/json")
@Consumes("application/json")
public class UsuarioResource
{
    @Inject UsuarioService service;

    @GET
    @Operation(description = "Lista todos os usuários")
    @Tag(name="usuarios")
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
    @Tag(name="usuarios")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByID(@PathParam("id") Long id)
    {
        var usuario = this.service.findByID(id);
        var dto = this.service.getMapper().convertToDTO(usuario.get());
        return Response
                .ok(dto)
                .build();
    }

    @GET
    @Path("/login/{login}")
    @Operation(description = "Buscar usuário pelo LOGIN")
    @Tag(name="usuarios")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByLogin(@PathParam("login") String login)
    {
        var usuario = this.service.findByLogin(login);
        if (!usuario.isPresent())
        {
            return Response
                    .noContent()
                    .build();
        }
        var dto = this.service.getMapper().convertToDTO(usuario.get());
        return Response
                .ok(null)
                .build();
    }

    @POST
    @Operation(description = "Cadastra um novo usuário")
    @Tag(name="usuarios")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response create(@RequestBody UsuarioDTO dto) throws BaseServiceException
    {
        var usuario = this.service.getMapper().convertToModel(dto);
        this.service.addEdit(usuario);
        dto = this.service.getMapper().convertToDTO(usuario);
        return Response
                .ok(dto)
                .build();
    }

    @PUT
    @Operation(description = "Atualiza os dados do usuário")
    @Tag(name="usuarios")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response update(@RequestBody UsuarioDTO dto) throws BaseServiceException
    {
        var usuario = this.service.getMapper().convertToModel(dto);
        this.service.addEdit(usuario);
        dto = this.service.getMapper().convertToDTO(usuario);
        return Response
                .ok(dto)
                .build();
    }

    @DELETE
    @Operation(description = "Deleta o usuário")
    @Tag(name="usuarios")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response delete(@RequestBody UsuarioDTO dto) throws BaseServiceException
    {
        var usuario = this.service.getMapper().convertToModel(dto);
        this.service.remove(usuario);
        return Response
                .noContent()
                .build();
    }
}