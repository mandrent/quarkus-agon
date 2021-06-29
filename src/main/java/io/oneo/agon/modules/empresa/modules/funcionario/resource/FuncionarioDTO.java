package io.oneo.agon.modules.empresa.modules.funcionario.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.oneo.agon.modules.empresa.modules.cargo.resource.CargoDTO;
import io.oneo.agon.modules.empresa.modules.funcionario.type.EstadoCivilTipo;
import io.oneo.agon.modules.empresa.modules.funcionario.type.SexoTipo;
import io.oneo.agon.modules.endereco.resource.EnderecoDTO;
import io.oneo.agon.modules.telefone.resource.TelefoneDTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FuncionarioDTO implements Serializable
{
    private static final long serialVersionUID = 4660590782409539353L;

    public Long id;

    public CargoDTO cargo;

    public String matricula;

    public String nome;

    public String sobreNome;

    public String maeNome;

    public String maeSobrenome;

    public EstadoCivilTipo estadoCivilTipo;

    public SexoTipo sexo;

    public int idade;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("nascimento")
    public LocalDateTime nascimento;

    public EnderecoDTO endereco;

    public TelefoneDTO telefone;

    public String rgdoc;

    public String cpf;

    public String ctps;

    public String titulo;

    public String pis;

    public String cnh;

    public String reservista;

    public String passaporte;

    public String certidaoCasamento;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("admissao")
    public LocalDateTime admissao;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("demissao")
    public LocalDateTime demissao;

    public List<FuncionarioDependenteDTO> dependenteLista = new ArrayList<FuncionarioDependenteDTO>();
}