package io.oneo.agon.modules.telefone.service;

import io.oneo.agon.modules.common.service.BaseService;
import io.oneo.agon.modules.telefone.exception.TelefoneException;
import io.oneo.agon.modules.telefone.mapper.TelefoneMapper;
import io.oneo.agon.modules.telefone.model.Telefone;
import io.oneo.agon.modules.telefone.repository.TelefoneRepository;
import io.oneo.agon.modules.telefone.type.TelefoneTipo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@ApplicationScoped
public class TelefoneService extends BaseService<Telefone, Long> implements ITelefoneService
{
    private final Logger logger = LoggerFactory.getLogger(TelefoneService.class);

    @Inject TelefoneRepository repo;

    @Inject TelefoneMapper mapper;

    public TelefoneMapper mapper() { return this.mapper; }

    @Override
    public String validarFormatoNumero(String numero)
    {
        var pattern = Pattern.compile("[0-9]");
        var matcher = pattern.matcher(numero);
        var result = matcher.group();
        return result;
    }

    public Optional<Telefone> findByNumber(String numero)
    {
        return this.repo.findByNumber(this.validarFormatoNumero(numero));
    }

    public List<Telefone> listByDDD(String ddd)
    {
        return ddd.equals(null) && ddd.length() < 2 ? Collections.emptyList() : this.repo.listByDDD(ddd);
    }

    public List<Telefone> listByType(Integer type)
    {
        return this.repo.listByType(TelefoneTipo.validate(type));
    }

    public Optional<Telefone> validate(Telefone telefone) throws TelefoneException
    {
        try
        {
            var phone = super.findByID(telefone.id);
            return phone.isPresent() ? phone : this.findByNumber(telefone.numero);
        }
        catch (Exception e)
        {
            this.logger.error(e.getMessage());
            throw new TelefoneException("Erro ao gravar os dados do telefone!", e);
        }
    }

    @Transactional
    public void addEdit(Telefone telefone) throws TelefoneException
    {
        try
        {
            if (telefone.id == null)
            {
                super.create(telefone);
            }
            super.update(telefone);
        }
        catch (Exception e)
        {
            this.logger.error(e.getMessage());
            throw new TelefoneException("Erro ao gravar os dados do telefone!", e);
        }
    }


}