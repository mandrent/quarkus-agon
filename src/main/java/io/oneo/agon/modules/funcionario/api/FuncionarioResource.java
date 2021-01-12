package io.oneo.agon.modules.funcionario.api;

import io.oneo.agon.modules.funcionario.model.Funcionario;
import io.oneo.agon.modules.funcionario.service.FuncionarioService;
import io.oneo.agon.modules.funcionario.resource.FuncionarioDTO;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/funcionarios")
@Produces("application/json")
@Consumes("application/json")
public class FuncionarioResource
{
    @Inject FuncionarioService service;

    @GET
    public Response list()
    {
        List<FuncionarioDTO> dtos = this.service.convertList(this.service.listar(), FuncionarioDTO.class);
        return Response
                .ok(dtos)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response findByID(@PathParam("id") Long id)
    {
        Optional<Funcionario> opt = this.service.findByID(id);
        FuncionarioDTO dto = this.service.convertOne(opt.get(), FuncionarioDTO.class);
        return Response
                .ok(dto)
                .build();
    }



}