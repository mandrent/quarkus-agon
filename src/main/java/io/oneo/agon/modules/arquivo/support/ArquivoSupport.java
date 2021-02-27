package io.oneo.agon.modules.arquivo.support;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class ArquivoSupport
{
    private String nomeDiretorioUpload;

    private Path diretorioUpload;

    public String obterNome(String nomeArquivo)
    {
        return FilenameUtils.removeExtension(nomeArquivo);
    }

    public String obterExtensao(String nomeArquivo)
    {
        return FilenameUtils.getExtension(nomeArquivo).toLowerCase();
    }

    public boolean validarTamanho(long tamanho)
    {
        long limite = 25L * 1024L * 1024L;
        return limite >= tamanho;
    }

    public boolean validar(String extensao, long tamanho)
    {
        boolean foto = extensao.equalsIgnoreCase(".jpg") || extensao.equalsIgnoreCase(".jpeg")
                || extensao.equalsIgnoreCase(".png");

        boolean portfolio = extensao.equalsIgnoreCase(".doc") || extensao.equalsIgnoreCase(".docx")
                || extensao.equalsIgnoreCase(".pdf") || extensao.equalsIgnoreCase(".ppt");

        boolean valido = foto || portfolio;
        return valido && this.validarTamanho(tamanho);
    }

    private void tratarExistenciaPastaUpload() throws IOException
    {
        boolean semPasta = !Files.exists(this.diretorioUpload);
        if (semPasta)
        {
            Files.createDirectories(this.diretorioUpload);
        }
    }

    public Optional<String> obterHashLocal(String hash) throws IOException
    {
        this.tratarExistenciaPastaUpload();
        try (Stream<Path> walk = Files.walk(this.diretorioUpload))
        {
            var arquivo = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString())
                    .filter(x -> x.equals(this.nomeDiretorioUpload + hash))
                    .findFirst();
            return arquivo;
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public String criarHashNome(String arquivo) throws IOException
    {
        var letters = arquivo.chars().boxed()
                .map(c -> (char) c.intValue())
                .collect(Collectors.toList());
        Collections.shuffle(letters);
        var stg = new StringBuilder(arquivo.length());
        letters.forEach(stg::append);
        var dado = stg.toString() + LocalDateTime.now().toString();
        return DigestUtils.md5Hex(dado.getBytes(StandardCharsets.UTF_8));
    }

    public void remover(String hash) throws IOException
    {
        var file = FileUtils.getFile(this.nomeDiretorioUpload + hash);
        if(file.exists())
        {
            FileUtils.forceDelete(file);
        }
    }

    /*
    public void copiar(String hash, MultipartFile file) throws IOException
    {
        this.tratarExistenciaPastaUpload();
        Path pasta = this.diretorioUpload.resolve(hash);
        file.transferTo(pasta.toFile());
    }*/




}