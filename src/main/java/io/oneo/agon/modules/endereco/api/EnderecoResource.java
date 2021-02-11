package io.oneo.agon.modules.endereco.api;

import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.endereco.resource.dto.EnderecoDTO;
import io.oneo.agon.modules.endereco.service.EnderecoService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("enderecos")
@Produces("application/json")
@Consumes("application/json")
public class EnderecoResource
{
    @Inject EnderecoService service;

    @POST
    @Operation(description = "Cadastra um novo endereco")
    @Tag(name="enderecos")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response create(@RequestBody EnderecoDTO dto) throws BaseServiceException
    {
        var endereco = this.service.getMapper().convertToModel(dto);
        this.service.addEdit(endereco);
        dto = this.service.getMapper().convertToDTO(endereco);
        return Response
                .ok(dto)
                .build();
    }

    @POST
    @Path("/validate")
    @Operation(description = "Cadastra um novo endereco")
    @Tag(name="enderecos")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response validate(@RequestBody EnderecoDTO dto) throws BaseServiceException
    {
        if (dto.getId() != null)
        {
            return this.findByID(dto.getId());
        }
        var endereco = this.service.getMapper().convertToModel(dto);
        this.service.addEdit(endereco);
        dto = this.service.getMapper().convertToDTO(endereco);
        return Response
                .ok(dto)
                .build();
    }

    @GET
    @Operation(description = "Lista todos os enderecos")
    @Tag(name="enderecos")
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
    @Operation(description = "Busca o endereco pelo ID")
    @Tag(name="enderecos")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByID(@PathParam("id") Long id)
    {
        var endereco = this.service.findByID(id).get();
        var dto = this.service.getMapper().convertToDTO(endereco);
        return Response
                .ok(dto)
                .build();
    }
}