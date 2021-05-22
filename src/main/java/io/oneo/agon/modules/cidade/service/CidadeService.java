package io.oneo.agon.modules.cidade.service;

import io.oneo.agon.modules.cidade.exception.CidadeServiceException;
import io.oneo.agon.modules.common.service.BaseService;
import io.oneo.agon.modules.cidade.mapper.CidadeMapper;
import io.oneo.agon.modules.cidade.model.Cidade;
import io.oneo.agon.modules.cidade.repository.CidadeRepository;
import io.oneo.agon.modules.estado.model.Estado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CidadeService extends BaseService<Cidade, Long>
{
    private final Logger logger = LoggerFactory.getLogger(CidadeService.class);

    @Inject CidadeRepository repo;

    @Inject CidadeMapper mapper;

    public CidadeMapper mapper() { return this.mapper; }

    public Optional<Cidade> findByName(String name)
    {
        if (name.equalsIgnoreCase(null))
        {
            return Optional.empty();
        }
        var cidade = this.repo.findByName(name);
        return cidade.isPresent() ? cidade : Optional.empty();
    }

    public Optional<Cidade> findByCode(String code)
    {
        if (code.equals(null))
        {
            return Optional.empty();
        }
        var cidade = this.repo.findByCode(code);
        return cidade.isPresent() ? cidade : Optional.empty();
    }

    public List<Cidade> listByState(Estado estado)
    {
        return this.repo.listByState(estado);
    }

    public Optional<Cidade> validate(Cidade cidade) throws CidadeServiceException
    {
        var result = super.findByID(cidade.getId());
        return result.isPresent() ? result : this.findByCode(cidade.getCodigo());
    }

    @Transactional
    public void addEdit(Cidade cidade) throws CidadeServiceException
    {
        try
        {
            if (cidade.getId() == null)
            {
                super.create(cidade);
            }
            super.update(cidade);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
            throw new CidadeServiceException("Erro ao gravar os dados do usuário", e);
        }
    }


}