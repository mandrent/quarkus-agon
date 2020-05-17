package io.oneo.agon.modules.acesso.modules.grupo.repository;

import io.oneo.agon.modules.acesso.modules.grupo.model.Grupo;
import io.oneo.agon.modules.acesso.modules.usuario.type.GrupoTipo;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class GrupoRepository implements PanacheRepositoryBase<Grupo, Long>
{
    public List<Grupo> listarPorDescricao(GrupoTipo tipo) { return this.find("tipo", tipo).list(); }
}