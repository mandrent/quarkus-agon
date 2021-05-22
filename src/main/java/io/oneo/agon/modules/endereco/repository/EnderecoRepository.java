package io.oneo.agon.modules.endereco.repository;

import io.oneo.agon.modules.endereco.model.Endereco;
import io.oneo.agon.modules.endereco.type.ComplementoTipo;
import io.oneo.agon.modules.endereco.type.LogradouroTipo;
import io.oneo.agon.modules.endereco.type.MoradiaTipo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco>
{
    public Optional<Endereco> findByReferences(LogradouroTipo logradouro, MoradiaTipo moradia, ComplementoTipo complemento)
    {
        return this.find("logradouro = :logradouro and moradia = :moradia and complemento = :complemento",
                Parameters.with("logradouro", logradouro)
                        .and("moradia", moradia)
                        .and("complemento", complemento)).firstResultOptional();
    }
}