package io.oneo.agon.modules.empresa.modules.funcionario.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.oneo.agon.modules.empresa.modules.cargo.resource.dto.CargoDTO;
import io.oneo.agon.modules.empresa.modules.funcionario.type.EstadoCivilTipo;
import io.oneo.agon.modules.empresa.modules.funcionario.type.SexoTipo;
import io.oneo.agon.modules.endereco.resource.dto.EnderecoDTO;
import io.oneo.agon.modules.telefone.resource.dto.TelefoneDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuncionarioDTO implements Serializable
{
    private static final long serialVersionUID = 4660590782409539353L;

    private Long id;

    private CargoDTO cargo;

    private String matricula;

    private String nome;

    private String sobreNome;

    private String maeNome;

    private String maeSobrenome;

    private EstadoCivilTipo estadoCivilTipo;

    private SexoTipo sexo;

    private int idade;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("nascimento")
    private LocalDateTime nascimento;

    private EnderecoDTO endereco;

    private TelefoneDTO telefone;

    private String rgdoc;

    private String cpf;

    private String ctps;

    private String titulo;

    private String pis;

    private String cnh;

    private String reservista;

    private String passaporte;

    private String certidaoCasamento;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("admissao")
    private LocalDateTime admissao;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("demissao")
    private LocalDateTime demissao;

    private List<FuncionarioDependenteDTO> dependenteLista = new ArrayList<FuncionarioDependenteDTO>();
}