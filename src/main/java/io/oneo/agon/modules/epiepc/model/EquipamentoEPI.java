package io.oneo.agon.modules.epiepc.model;

import io.oneo.agon.modules.empresa.modules.funcionario.model.Funcionario;
import io.oneo.agon.modules.epiepc.type.AtenuacaoTipo;
import io.oneo.agon.modules.fabricante.model.Fabricante;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "epi_equipamento", schema = "agondb")
public class EquipamentoEPI implements Serializable
{
    public static final long serialVersionUID = 1016746741607364245L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", length = 50)
    @NotNull
    public String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fabricante_id", referencedColumnName = "id")
    public Fabricante fabricante;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    private Funcionario funcionario;

    @Column(name = "ca_code", length = 20)
    @NotNull
    public String codigoCA;

    @Column(name = "atenuacao")
    @Enumerated(EnumType.STRING)
    public AtenuacaoTipo atenuacao;

    @Column(name = "quantidade")
    @NotNull
    public int quantidade;

    @Column(name = "entrega_dt")
    @NotNull
    public LocalDateTime entrega;

    @Column(name = "devolucao_dt")
    @NotNull
    public LocalDateTime devolucao;

    public EquipamentoEPI() { }
}