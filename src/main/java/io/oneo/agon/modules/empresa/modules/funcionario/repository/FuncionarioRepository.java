package io.oneo.agon.modules.empresa.modules.funcionario.repository;

import io.oneo.agon.modules.empresa.modules.funcionario.model.Funcionario;
import io.oneo.agon.modules.telefone.model.Telefone;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class FuncionarioRepository implements PanacheRepository<Funcionario>
{
    public Optional<Funcionario> findByRegistration(String matricula)
    {
        return this.find("matricula", matricula).firstResultOptional();
    }

    public Optional<Funcionario> findByRgdoc(String rgdoc)
    {
        return this.find("rgdoc", rgdoc).firstResultOptional();
    }

    public Optional<Funcionario> findByCPF(String cpf)
    {
        return this.find("cpf", cpf).firstResultOptional();
    }

    public Optional<Funcionario> findByCtps(String ctps)
    {
        return this.find("ctps", ctps).firstResultOptional();
    }

    public Optional<Funcionario> findByTitle(String titulo)
    {
        return this.find("titulo", titulo).firstResultOptional();
    }

    public Optional<Funcionario> findByPIS(String pis)
    {
        return this.find("pis", pis).firstResultOptional();
    }

    public Optional<Funcionario> findByCNH(String cnh)
    {
        return this.find("cnh", cnh).firstResultOptional();
    }

    public Optional<Funcionario> findByReservista(String reservista)
    {
        return this.find("reservista", reservista).firstResultOptional();
    }

    public Optional<Funcionario> findByPassaport(String passaporte)
    {
        return this.find("passaporte", passaporte).firstResultOptional();
    }

    public Optional<Funcionario> findByPhone(Telefone telefone)
    {
        return this.find("telefone", telefone).firstResultOptional();
    }

    public Optional<Funcionario> findByFullname(String nome, String sobrenome)
    {
        return this.find("nome = :nome and sobrenome = :sobrenome",
                Parameters.with("nome", nome)
                        .and("sobrenome", sobrenome)).firstResultOptional();
    }

}