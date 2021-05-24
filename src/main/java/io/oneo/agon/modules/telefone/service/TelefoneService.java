package io.oneo.agon.modules.telefone.service;

import io.oneo.agon.modules.common.service.BaseService;
import io.oneo.agon.modules.telefone.exception.TelefoneServiceException;
import io.oneo.agon.modules.telefone.mapper.TelefoneMapper;
import io.oneo.agon.modules.telefone.model.Telefone;
import io.oneo.agon.modules.telefone.repository.TelefoneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
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
        return numero.equals(null) ? Optional.empty() : this.repo.findByNumber(this.validarFormatoNumero(numero));
    }

    public Optional<Telefone> validate(Telefone telefone) throws TelefoneServiceException
    {
        try
        {
            var phone = super.findByID(telefone.getId());
            return phone.isPresent() ? phone : this.findByNumber(telefone.getNumero());
        }
        catch (Exception e)
        {
            this.logger.error(e.getMessage());
            throw new TelefoneServiceException("Erro ao gravar os dados do telefone!", e);
        }
    }

    @Transactional
    public void addEdit(Telefone telefone) throws TelefoneServiceException
    {
        try
        {
            if (telefone.getId() == null)
            {
                super.create(telefone);
            }
            super.update(telefone);
        }
        catch (Exception e)
        {
            this.logger.error(e.getMessage());
            throw new TelefoneServiceException("Erro ao gravar os dados do telefone!", e);
        }
    }


}