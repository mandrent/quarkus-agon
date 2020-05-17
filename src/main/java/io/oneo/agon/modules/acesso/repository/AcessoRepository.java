package io.oneo.agon.modules.acesso.repository;

import io.oneo.agon.modules.acesso.model.Acesso;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class AcessoRepository implements PanacheRepositoryBase<Acesso, Long>
{
}