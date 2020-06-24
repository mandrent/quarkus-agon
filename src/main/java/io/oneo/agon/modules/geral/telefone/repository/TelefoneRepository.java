package io.oneo.agon.modules.geral.telefone.repository;

import io.oneo.agon.modules.geral.telefone.model.Telefone;
import io.oneo.agon.modules.geral.telefone.type.TelefoneTipo;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class TelefoneRepository implements PanacheRepositoryBase<Telefone, Long>
{
    public Telefone buscarPorNumero(String numero) { return this.find("numero", numero).firstResult(); }

    public List<Telefone> listarPorDDD(String ddd) { return this.find("ddd", ddd).list(); }

    public List<Telefone> listarPorTipo(TelefoneTipo tipo) { return this.find("tipo", tipo).list(); }
}