package io.oneo.agon.modules.funcionario.support.dto;

import io.oneo.agon.modules.funcionario.modules.documento.type.EstadoCivilTipo;
import io.oneo.agon.modules.funcionario.modules.documento.type.SexoTipo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
public class FuncionarioDocumentoDTO implements Serializable
{
    private static final long serialVersionUID = 5691899876170122151L;

    private FuncionarioDTO funcionario;

    private String nome;

    private String sobreNome;

    private String maeNome;
    
    private String maeSobre;

    private EstadoCivilTipo estadoCivilTipo;

    private SexoTipo sexo;

    private int idade;

    private LocalDateTime nascimento;

    private String rgdoc;

    private String cpf;

    private String ctps;

    private String titulo;

    private String pis;

    private String cnh;

    private String reservista;

    private String passaporte;

    private String certidaoCasa;
}