package io.oneo.agon.modules.arquivo.proxy;

import io.oneo.agon.modules.arquivo.support.MultipartBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;

@Produces("application/json")
@RegisterRestClient(configKey = "arquivoProxy")
public interface ArquivoProxy
{
    @POST
    @Path("/upload")
    @Consumes("multipart/form-data")
    String upload(@MultipartForm MultipartBody data) throws IOException;
}