package io.oneo.agon.modules.arquivo.service;

import io.oneo.agon.modules.arquivo.exception.ArquivoNaoLocalizadoException;
import io.oneo.agon.modules.arquivo.model.Arquivo;

import java.io.IOException;
import java.util.Optional;

public interface IArquivoService
{
    Optional<Arquivo> findFileByID(Long id) throws ArquivoNaoLocalizadoException;

    Optional<Arquivo> findByHash(String hash) throws ArquivoNaoLocalizadoException;

    String validateUniqueHash(String hash) throws IOException;

    void removeByLocalHash(String hash) throws IOException;
}