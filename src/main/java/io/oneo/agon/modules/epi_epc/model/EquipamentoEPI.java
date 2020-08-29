package io.oneo.agon.modules.epi_epc.model;

import io.oneo.agon.modules.epi_epc.type.AtenuacaoTipo;
import io.oneo.agon.modules.funcionario.model.Funcionario;
import io.oneo.agon.modules.geral.fabricante.model.Fabricante;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "epi_equipamento", schema = "agondb")
public class EquipamentoEPI extends PanacheEntity implements Serializable
{
    public static final long serialVersionUID = 1016746741607364245L;

    @Column(name = "descricao")
    @NotNull
    @Size(min = 3, max = 50)
    public String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fabricante_id", referencedColumnName = "id")
    public Fabricante fabricante;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "funcionario_id", referencedColumnName = "idfnc")
    private Funcionario funcionario;

    @Column(name = "ca_code")
    @NotNull
    @Size(min = 5, max = 20)
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
}