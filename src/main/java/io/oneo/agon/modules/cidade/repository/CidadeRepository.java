package io.oneo.agon.modules.cidade.repository;

import io.oneo.agon.modules.cidade.model.Cidade;
import io.oneo.agon.modules.estado.model.Estado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CidadeRepository implements PanacheRepository<Cidade>
{
    public Optional<Cidade> findByName(String name)
    {
        var cidade = this.find("name", name).firstResult();
        return Optional.ofNullable(cidade);
    }

    public Optional<Cidade> findByCode(String codigo)
    {
        return this.find("codigo", codigo).firstResultOptional();
    }

    public List<Cidade> listByState(Estado estado)
    {
        return this.find("estado", estado).list();
    }

}