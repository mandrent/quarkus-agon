package io.oneo.agon.modules.empresa.modules.funcionario.api;

import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.empresa.modules.cargo.client.CargoClient;
import io.oneo.agon.modules.empresa.modules.cargo.resource.dto.CargoDTO;
import io.oneo.agon.modules.empresa.modules.funcionario.model.Funcionario;
import io.oneo.agon.modules.empresa.modules.funcionario.resource.FuncionarioDTO;
import io.oneo.agon.modules.empresa.modules.funcionario.service.FuncionarioService;
import io.oneo.agon.modules.endereco.client.EnderecoClient;
import io.oneo.agon.modules.endereco.resource.dto.EnderecoDTO;
import io.oneo.agon.modules.telefone.client.TelefoneClient;
import io.oneo.agon.modules.telefone.resource.dto.TelefoneDTO;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("empresas/funcionarios")
@Produces("application/json")
@Consumes("application/json")
public class FuncionarioResource
{
    @Inject FuncionarioService service;

    @Inject
    @RestClient
    CargoClient cargoClient;

    @Inject
    @RestClient
    TelefoneClient telefoneClient;

    @Inject
    @RestClient
    EnderecoClient enderecoClient;

    private CargoDTO validarCargo(CargoDTO cargo) throws BaseServiceException
    {
        if (cargo.getId() != null)
        {
            return this.cargoClient.findByID(cargo.getId());
        }
        return this.cargoClient.create(cargo);
    }

    private TelefoneDTO validarTelefone(TelefoneDTO telefone) throws BaseServiceException
    {
        if (telefone.getId() != null)
        {
            return this.telefoneClient.findByID(telefone.getId());
        }
        return this.telefoneClient.create(telefone);
    }

    private EnderecoDTO validarEndereco(EnderecoDTO endereco) throws BaseServiceException
    {
        if (endereco.getId() != null)
        {
            this.enderecoClient.findByID(endereco.getId());
        }
        return this.enderecoClient.create(endereco);
    }

    @POST
    @Operation(description = "Cadastra um novo funcionário")
    @Tag(name="funcionarios")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response create(@RequestBody FuncionarioDTO dto) throws BaseServiceException
    {
        var cargo = this.validarCargo(dto.getCargo());
        var telefone = this.validarTelefone(dto.getTelefone());
        var endereco = this.validarEndereco(dto.getEndereco());
        dto.setCargo(cargo);
        dto.setTelefone(telefone);
        dto.setEndereco(endereco);
        var funcionario = this.service.getMapper().convertToModel(dto);
        this.service.addEdit(funcionario);
        dto = this.service.getMapper().convertToDTO(funcionario);
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
        var list = this.service.list();
        var dtos = this.service.getMapper().convertToDtoList(list);
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
        var funcionario = this.service.findByID(id).get();
        var dto = this.service.getMapper().convertToDTO(funcionario);
        return Response
                .ok(dto)
                .build();
    }


}