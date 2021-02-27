package io.oneo.agon.modules.arquivo.resource.dto;

import io.oneo.agon.modules.arquivo.type.ArquivoTipo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ArquivoDTO implements Serializable
{
    private static final long serialVersionUID = 8032063492587326702L;
    
    public Long id;

    public ArquivoTipo tipo;

    public String hash;

    public String nome;

    public String extensao;

    public long tamanho;

    public String localizacao;

    public LocalDateTime inclusao;
}