package io.oneo.agon.modules.telefone.service;

import io.oneo.agon.modules.common.service.BaseService;
import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.telefone.mapper.TelefoneMapper;
import io.oneo.agon.modules.telefone.model.Telefone;
import io.oneo.agon.modules.telefone.repository.TelefoneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ApplicationScoped
public class TelefoneService extends BaseService<Telefone, Long> implements ITelefoneService
{
    private final Logger logger = LoggerFactory.getLogger(TelefoneService.class);

    @Inject TelefoneRepository repo;

    @Inject TelefoneMapper mapper;

    public TelefoneMapper getMapper() { return this.mapper; }

    private String validaFormatoNumero(String numero)
    {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(numero);
        return matcher.group();
    }

    public Optional<Telefone> findByNumber(String numero)
    {
        if (numero.equalsIgnoreCase(null))
        {
            return Optional.empty();
        }
        String novo = this.validaFormatoNumero(numero);
        return this.repo.findByNumber(novo);
    }

    @Transactional
    public Telefone addEdit(Telefone telefone) throws BaseServiceException
    {
        try
        {
            if (telefone.getId() == null)
            {
                return this.create(telefone);
            }
            return this.update(telefone);
        }
        catch (Exception e)
        {
            this.logger.error(e.getMessage());
            throw new BaseServiceException("Erro ao gravar os dados do telefone!", e);
        }
    }
}