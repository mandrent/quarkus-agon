package io.oneo.agon.modules.empresa.modules.cargo.api;

import io.oneo.agon.modules.empresa.modules.cargo.exception.CargoServiceException;
import io.oneo.agon.modules.empresa.modules.cargo.resource.dto.CargoDTO;
import io.oneo.agon.modules.empresa.modules.cargo.service.CargoService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("empresas/cargos")
@Produces("application/json")
@Consumes("application/json")
public class CargoResource
{
    @Inject CargoService service;

    @GET
    @Operation(description = "Lista os cargos")
    @Tag(name="cargos")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response list()
    {
        var list = this.service.getMapper().dtoList(this.service.list());
        return Response
                .ok(list)
                .build();
    }

    @GET
    @Path("/{id}")
    @Operation(description = "Buscar cargo por ID")
    @Tag(name="cargos")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByID(@PathParam("id") Long id)
    {
        var cargo = this.service.findByID(id);
        var dto = this.service.getMapper().getDTO(cargo.get());
        return Response
                .ok(dto)
                .build();
    }

    @POST
    @Operation(description = "Cadastra novo cargo")
    @Tag(name="cargos")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response create(@RequestBody CargoDTO dto) throws CargoServiceException
    {
        var cargo = this.service.getMapper().getModel(dto);
        this.service.addEdit(cargo);
        dto = this.service.getMapper().getDTO(cargo);
        return Response
                .ok(dto)
                .build();
    }

    @POST
    @Path("/validate")
    @Operation(description = "Valida o CargoProxy")
    @Tag(name="cargos")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response validate(@RequestBody CargoDTO dto) throws CargoServiceException
    {
        if (dto.getId() != null)
        {
            var cargo = this.service.findByID(dto.getId());
            dto = this.service.getMapper().getDTO(cargo.get());
            return Response.ok(dto)
                    .build();
        }

        var cargo = this.service.getMapper().getModel(dto);
        this.service.addEdit(cargo);
        dto = this.service.getMapper().getDTO(cargo);
        return Response
                .ok(dto)
                .build();
    }

    @GET
    @Path("/name/{name}")
    @Operation(description = "Buscar cargo por nome")
    @Tag(name="cargos")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByName(@PathParam("name") String name)
    {
        var cargo = this.service.findByName(name);
        if (cargo.isPresent())
        {
            var dto = this.service.getMapper().getDTO(cargo.get());
            return Response
                    .ok(dto)
                    .build();
        }
        return Response
                .noContent()
                .build();
    }

    @PUT
    @Operation(description = "Atualiza os dados do usuário")
    @Tag(name="cargos")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response update(@RequestBody CargoDTO dto) throws CargoServiceException
    {
        var cargo = this.service.getMapper().getModel(dto);
        this.service.addEdit(cargo);
        dto = this.service.getMapper().getDTO(cargo);
        return Response
                .ok(dto)
                .build();
    }


}
