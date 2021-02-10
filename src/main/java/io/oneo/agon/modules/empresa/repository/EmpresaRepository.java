package io.oneo.agon.modules.empresa.repository;

import io.oneo.agon.modules.empresa.model.Empresa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class EmpresaRepository implements PanacheRepository<Empresa>
{
    public Optional<Empresa> findByCNPJ(String cnpj)
    {
        var empresa = this.find("cnpj", cnpj).firstResult();
        return Optional.of(empresa);
    }
}
