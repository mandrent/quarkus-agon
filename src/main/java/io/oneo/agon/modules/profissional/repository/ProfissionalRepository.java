package io.oneo.agon.modules.profissional.repository;

import io.oneo.agon.modules.profissional.model.Profissional;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class ProfissionalRepository implements PanacheRepository<Profissional>
{
    public Optional<Profissional> findByCodeDRT(String drt)
    {
        var profissional = this.find("drt", drt).firstResult();
        return Optional.of(profissional);
    }


}