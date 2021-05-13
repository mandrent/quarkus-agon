package io.oneo.agon.modules.arquivo.service;

import io.oneo.agon.modules.arquivo.exception.ArquivoServiceException;
import io.oneo.agon.modules.common.service.BaseService;
import io.oneo.agon.modules.arquivo.exception.ArquivoNaoLocalizadoException;
import io.oneo.agon.modules.arquivo.mapper.ArquivoMapper;
import io.oneo.agon.modules.arquivo.model.Arquivo;
import io.oneo.agon.modules.arquivo.repository.ArquivoRepository;
import io.oneo.agon.modules.arquivo.support.ArquivoSupport;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ArquivoService extends BaseService<Arquivo, Long> implements IArquivoService
{
    private final Logger logger = LoggerFactory.getLogger(ArquivoService.class);

    @Inject ArquivoRepository repo;

    @Inject ArquivoMapper mapper;

    @Inject ArquivoSupport support;

    public ArquivoMapper getMapper() { return this.mapper; }

    @Override
    public Optional<Arquivo> findFileByID(Long id) throws ArquivoNaoLocalizadoException
    {
        var arquivo = this.findByID(id);
        if (!arquivo.isPresent())
        {
            throw new ArquivoNaoLocalizadoException("ARQUIVO NÃO LOCALIZADO PELO ID: " + id);
        }
        return arquivo;
    }

    @Override
    public Optional<Arquivo> findByHash(String hash) throws ArquivoNaoLocalizadoException
    {
        var arquivo = this.repo.findByHashcode(hash);
        if (!arquivo.isPresent())
        {
            throw new ArquivoNaoLocalizadoException("ARQUIVO NÃO LOCALIZADO COM O HASH: " + hash);
        }
        return arquivo;
    }

    @Override
    public String validateUniqueHash(String hash) throws IOException
    {
        var local = this.support.obterHashLocal(hash);
        var arquivo = this.repo.findByHashcode(hash);
        if (!local.isPresent() && !arquivo.isPresent())
        {
            return hash;
        }
        return this.support.criarHashNome(hash);
    }

    @Override
    public void removeByLocalHash(String hash) throws IOException
    {
        var hashNome = this.support.obterHashLocal(hash);
        var arquivo = this.repo.findByHashcode(hash);
        if (hashNome.isPresent() && arquivo.isPresent())
        {
            this.support.remover(hash);
        }
        this.remove(arquivo.get());
    }


    public Arquivo addEdit(Arquivo arquivo) throws ArquivoServiceException
    {
        try
        {
            if (arquivo.getId() == null)
            {
                return this.create(arquivo);
            }
            return this.update(arquivo);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
            throw new ArquivoServiceException("Erro ao gravar o arquivo", e);
        }
    }

    private void saveFile(InputStream uploadedInputStream, String serverLocation)
    {
        try
        {
            OutputStream outpuStream = new FileOutputStream(new File(serverLocation));
            int read = 0;
            byte[] bytes = new byte[1024];
            outpuStream = new FileOutputStream(new File(serverLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                outpuStream.write(bytes, 0, read);
            }
            outpuStream.flush();
            outpuStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private String parseFileName(MultivaluedMap<String, String> headers)
    {
        List<String> list = new ArrayList<>();
        String[] content = headers.getFirst("Content-Disposition").split(";");
        Arrays.asList(content)
                .forEach(name -> {
                    if (name.trim().startsWith("filename"))
                    {
                        List<String> data = Arrays.asList(name.split("="));
                        String stg = data.get(0).trim().replaceAll("\"", "");
                        list.add(stg);
                    }
                });
        return list.get(0);
    }

    public Arquivo upload(MultipartFormDataInput input) throws IOException
    {
        var file = new Arquivo();
        var dataMap = input.getFormDataMap();
        var list = dataMap.get("file");
        list.forEach(arquivo -> {
            var headers = arquivo.getHeaders();
            try
            {
                file.setNome(this.parseFileName(headers));
                InputStream ism = arquivo.getBody(InputStream.class, null);
                this.saveFile(ism, file.getNome());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        });

        return null;
    }

}