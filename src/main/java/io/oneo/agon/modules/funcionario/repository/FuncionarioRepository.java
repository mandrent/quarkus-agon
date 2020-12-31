package io.oneo.agon.modules.funcionario.repository;

import io.oneo.agon.modules.funcionario.model.Funcionario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class FuncionarioRepository implements PanacheRepository<Funcionario>
{
    public Optional<Funcionario> findByRegistrationn(String matricula)
    {
        Funcionario funcionario = this.find("matricula", matricula).firstResult();
        return Optional.of(funcionario);
    }

}