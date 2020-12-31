package io.oneo.agon.modules.empresa.modules.setor.repository;

import io.oneo.agon.modules.empresa.modules.setor.model.EmpresaSetor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmpresaSetorRepository implements PanacheRepository<EmpresaSetor>
{

}