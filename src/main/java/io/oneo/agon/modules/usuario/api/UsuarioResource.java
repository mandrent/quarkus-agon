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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/usuarios")
@Produces("application/json")
@Consumes("application/json")
public class UsuarioResource
{
    @Inject UsuarioService service;

    @GET
    public Response listar()
    {
        List<UsuarioDTO> dtoList = new ArrayList<>();
        this.service.listar().forEach(usr -> {
            UsuarioDTO dto = this.service.convertOne(usr, UsuarioDTO.class);
            dto.setId(usr.getId());
            dtoList.add(dto);
        });
        return Response
                .ok(dtoList)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorID(@PathParam("id") Long id)
    {
        Optional<Usuario> opt = this.service.buscarPorID(id);
        UsuarioDTO dto = this.service.convertOne(opt.get(), UsuarioDTO.class);
        dto.setId(opt.get().getId());
        return Response
                .ok(dto)
                .build();
    }

    @GET
    @Path("/login/{login}")
    public Response findByLogin(@PathParam("login") String login)
    {
        Optional<Usuario> usuario = this.service.findByLogin(login);
        if (usuario.isPresent())
        {
            UsuarioDTO dto = this.service.convertOne(usuario.get(), UsuarioDTO.class);
            return Response
                    .ok(dto)
                    .build();
        }
        return Response
                .noContent()
                .build();
    }

    @POST
    @Operation(description = "Cadastra um novo usuário")
    @Tag(name="usuarios")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response create(@RequestBody UsuarioDTO dto) throws BaseServiceException
    {
        Usuario usuario = this.service.convertOne(dto, Usuario.class);
        this.service.addEdit(usuario);
        dto = this.service.convertOne(usuario, UsuarioDTO.class);
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
        Usuario usuario = this.service.convertOne(dto, Usuario.class);
        this.service.addEdit(usuario);
        dto = this.service.convertOne(usuario, UsuarioDTO.class);
        return Response
                .ok(dto)
                .build();
    }

}