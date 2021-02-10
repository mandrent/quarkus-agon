package io.oneo.agon.modules.endereco.repository;

import io.oneo.agon.modules.endereco.model.Endereco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco>
{

}