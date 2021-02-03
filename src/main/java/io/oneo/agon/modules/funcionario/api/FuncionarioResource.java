package io.oneo.agon.modules.funcionario.api;

import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.funcionario.model.Funcionario;
import io.oneo.agon.modules.funcionario.service.FuncionarioService;
import io.oneo.agon.modules.funcionario.resource.FuncionarioDTO;
import io.oneo.agon.modules.usuario.model.Usuario;
import io.oneo.agon.modules.usuario.resource.dto.UsuarioDTO;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Path("/funcionarios")
@Produces("application/json")
@Consumes("application/json")
public class FuncionarioResource
{
    @Inject FuncionarioService service;

    @POST
    @Operation(description = "Cadastra um novo funcionário")
    @Tag(name="funcionarios")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response create(@RequestBody FuncionarioDTO dto) throws BaseServiceException
    {
        Funcionario funcionario = this.service.convertOne(dto, Funcionario.class);
        this.service.addEdit(funcionario);
        dto = this.service.convertOne(funcionario, FuncionarioDTO.class);
        return Response
                .ok(dto)
                .build();
    }

    @GET
    @Operation(description = "Lista todos os funcionários")
    @Tag(name="funcionarios")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response list()
    {
        List<Funcionario> list = this.service.listar();
        List<FuncionarioDTO> dtos = this.service.convertList(list, FuncionarioDTO.class);
        return Response
                .ok(dtos)
                .build();
    }

    @GET
    @Path("/{id}")
    @Operation(description = "Busca o usuário pelo ID")
    @Tag(name="funcionarios")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByID(@PathParam("id") Long id)
    {
        Funcionario funcionario = this.service.findByID(id).get();
        FuncionarioDTO dto = this.service.convertOne(funcionario, FuncionarioDTO.class);
        return Response
                .ok(dto)
                .build();
    }


}