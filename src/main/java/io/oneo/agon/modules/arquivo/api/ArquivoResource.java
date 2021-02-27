package io.oneo.agon.modules.arquivo.api;

import io.oneo.agon.modules.arquivo.exception.ArquivoNaoLocalizadoException;
import io.oneo.agon.modules.arquivo.service.ArquivoService;
import org.apache.http.HttpStatus;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

@Path("api/arquivos")
@Produces("application/json")
public class ArquivoResource
{
    @Inject ArquivoService service;

    @GET
    @Consumes("application/json")
    @Operation(description = "Lista todas as arquivos")
    @Tag(name="arquivos")
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
    @Consumes("application/json")
    @Operation(description = "Busca arquivo por ID")
    @Tag(name="arquivos")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByID(@PathParam("id") Long id)
    {
        var arquivo = this.service.findByID(id);
        if (!arquivo.isPresent())
        {
            return Response
                    .status(HttpStatus.SC_NOT_FOUND)
                    .build();
        }
        var dto = this.service.getMapper().convertToDTO(arquivo.get());
        return Response
                .ok(dto)
                .build();
    }

    @GET
    @Path("/{hashcode}")
    @Consumes("application/json")
    @Operation(description = "Busca arquivo por hashcode")
    @Tag(name="arquivos")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response findByHashcode(@PathParam("hashcode") String hashcode) throws ArquivoNaoLocalizadoException
    {
        var arquivo = this.service.findByHash(hashcode);
        if (!arquivo.isPresent())
        {
            return Response
                    .status(HttpStatus.SC_NOT_FOUND)
                    .build();
        }
        var dto = this.service.getMapper().convertToDTO(arquivo.get());
        return Response
                .ok(dto)
                .build();
    }

    @POST
    @Path("/upload")
    @Consumes("multipart/form-data")
    @Operation(description = "Faz o upload de arquivo")
    @Tag(name="arquivos")
    @APIResponse(responseCode = "200", description = "Ok")
    public Response upload(MultipartFormDataInput data) throws IOException
    {
        try(InputStream is = data.getFormDataPart("data", InputStream.class, null))
        {
            is.read();
            var arquivo = this.service.upload(data);
            var file = this.service.getMapper().convertToDTO(arquivo);
            return Response
                    .ok(file)
                    .build();
        } catch (Exception e)
        {
            return Response
                    .status(HttpStatus.SC_NOT_FOUND)
                    .build();
        }
    }

}