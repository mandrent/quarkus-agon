package io.oneo.agon.modules.arquivo.repository;

import io.oneo.agon.modules.arquivo.model.Arquivo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class ArquivoRepository implements PanacheRepository<Arquivo>
{
    public Optional<Arquivo> findByHashcode(String hashcode)
    {
        Arquivo arquivo = this.find("hashcode", hashcode).singleResult();
        return Optional.of(arquivo);
    }
}