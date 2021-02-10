package io.oneo.agon.modules.empresa.modules.cargo.repository;


import io.oneo.agon.modules.empresa.modules.cargo.model.Cargo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class CargoRepository implements PanacheRepository<Cargo>
{
    public Optional<Cargo> findByName(String nome)
    {
        return Optional.of(find("nome", nome).firstResult());
    }

    public Cargo findByFunction(String setor)
    {
        return find("setor", setor).firstResult();
    }

    public Cargo findBydesc(String desc)
    {
        return find("desc", desc).firstResult();
    }



}