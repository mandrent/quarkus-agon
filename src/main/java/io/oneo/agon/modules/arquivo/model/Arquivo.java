package io.oneo.agon.modules.arquivo.model;

import io.oneo.agon.modules.arquivo.type.ArquivoTipo;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Getter @Setter
@Entity
@Table(name = "arquivo", schema = "agondb")
public class Arquivo implements Serializable
{
    private static final long serialVersionUID = 776656101382634971L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private ArquivoTipo tipo;

    @Column(name = "hash", length = 255)
    private String hash;

    @Column(name = "nome", length = 150)
    private String nome;

    @Column(name = "extensao", length = 4)
    private String extensao;

    @Column(name = "tamanho", length = 4)
    private long tamanho;

    @Column(name = "localizacao", length = 100)
    private String localizacao;

    @Column(name = "inclusao_dt")
    private LocalDateTime inclusao;

    public Arquivo() { }
}