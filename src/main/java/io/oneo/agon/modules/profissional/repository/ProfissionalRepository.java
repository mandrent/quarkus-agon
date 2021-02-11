package io.oneo.agon.modules.profissional.repository;

import io.oneo.agon.modules.profissional.model.Profissional;
import io.oneo.agon.modules.usuario.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class ProfissionalRepository implements PanacheRepository<Profissional>
{
    public Optional<Profissional> findByUser(Usuario usuario)
    {
        var user = this.find("usuario", usuario).firstResult();
        return Optional.of(user);
    }

    public Optional<Profissional> findByDRT(String drt)
    {
        var user = this.find("drt", drt).firstResult();
        return Optional.of(user);
    }

    public Optional<Profissional> findBySesmt(Integer sesmt)
    {
        var user = this.find("sesmt", sesmt).firstResult();
        return Optional.of(user);
    }

    public Optional<Profissional> findByCRM(String crm)
    {
        var user = this.find("crm", crm).firstResult();
        return Optional.of(user);
    }

    public Optional<Profissional> findByCrea(String crea)
    {
        var user = this.find("crea", crea).firstResult();
        return Optional.of(user);
    }

    public Optional<Profissional> findByCoren(String coren)
    {
        var user = this.find("coren", coren).firstResult();
        return Optional.of(user);
    }

}