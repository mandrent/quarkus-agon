package io.oneo.agon.modules.telefone.repository;

import io.oneo.agon.modules.telefone.model.Telefone;
import io.oneo.agon.modules.telefone.type.TelefoneTipo;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TelefoneRepository implements PanacheRepositoryBase<Telefone, Long>
{
    public Optional<Telefone> findByNumber(String numero) { return this.find("numero", numero).firstResultOptional(); }

    public List<Telefone> listByDDD(String ddd) { return this.find("ddd", ddd).list(); }

    public List<Telefone> listByType(TelefoneTipo tipo) { return this.find("tipo", tipo).list(); }
}