package io.oneo.agon.modules.empresa.modules.cargo.repository;

import io.oneo.agon.modules.empresa.modules.cargo.model.Cargo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class CargoRepository implements PanacheRepository<Cargo>
{
    public Optional<Cargo> findByName(String nome)
    {
        return this.find("nome", nome).firstResultOptional();
    }

    public Optional<Cargo> findByFunction(String funcao) { return this.find("funcao", funcao).firstResultOptional(); }

    public Optional<Cargo> findBySector(String setor) { return this.find("setor", setor).firstResultOptional(); }

    public Optional<Cargo> findByReference(String referencia)
    {
        return this.find("referencia", referencia).firstResultOptional();
    }

    public Optional<Cargo> findByDescription(String description)
    {
        return this.find("description", description).firstResultOptional();
    }

    public Optional<Cargo> findByNameSectorFunction(String nome, String setor, String funcao)
    {
        return this.find("nome = :nome and setor = :setor and funcao = :funcao",
                Parameters.with("nome", nome)
                        .and("setor", setor)
                        .and("funcao", funcao)).firstResultOptional();
    }
}