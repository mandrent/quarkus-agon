package io.oneo.agon.modules.profissional.repository;

import io.oneo.agon.modules.profissional.model.Profissional;
import io.oneo.agon.modules.telefone.model.Telefone;
import io.oneo.agon.modules.usuario.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class ProfissionalRepository implements PanacheRepository<Profissional>
{
    public Optional<Profissional> findByUser(Usuario usuario) { return this.find("usuario", usuario).firstResultOptional(); }

    public Optional<Profissional> findByFullname(String nome, String sobrenome)
    {
        return this.find("nome = :nome and sobrenome = :sobrenome",
                Parameters
                        .with("nome", nome)
                        .and("sobrenome", sobrenome)).firstResultOptional();
    }

    public Optional<Profissional> findByDRT(String drt) { return this.find("drt", drt).firstResultOptional(); }

    public Optional<Profissional> findByCRM(String crm) { return this.find("crm", crm).firstResultOptional(); }

    public Optional<Profissional> findByCrea(String crea) { return this.find("crea", crea).firstResultOptional(); }

    public Optional<Profissional> findByCoren(String coren) { return this.find("coren", coren).firstResultOptional(); }

    public Optional<Profissional> findByPhone(Telefone telefone) { return this.find("telefone", telefone).firstResultOptional(); }
}