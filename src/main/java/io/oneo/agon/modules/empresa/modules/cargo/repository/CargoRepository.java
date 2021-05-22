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

    public Optional<Cargo> findByFunction(String setor)
    {
        return this.find("setor", setor).firstResultOptional();
    }

    public Optional<Cargo> findBydesc(String desc)
    {
        return this.find("desc", desc).firstResultOptional();
    }

    public Optional<Cargo> findByNameSectorFunction(String name, String sector, String function)
    {
        return this.find("name = :name and sector = :sector and function = :function",
                Parameters.with("name", name)
                        .and("sector", sector)
                        .and("function", function)).firstResultOptional();

    }
}