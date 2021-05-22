package io.oneo.agon.modules.endereco.service;

import io.oneo.agon.modules.common.service.BaseService;
import io.oneo.agon.modules.endereco.exception.EnderecoServiceException;
import io.oneo.agon.modules.endereco.mapper.EnderecoMapper;
import io.oneo.agon.modules.endereco.model.Endereco;
import io.oneo.agon.modules.endereco.repository.EnderecoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

@ApplicationScoped
public class EnderecoService extends BaseService<Endereco, Long> implements IEnderecoService
{
    private final Logger logger = LoggerFactory.getLogger(EnderecoService.class);

    @Inject EnderecoRepository repo;

    @Inject EnderecoMapper mapper;

    public EnderecoMapper mapper() { return this.mapper; }

    @Override
    public Optional<Endereco> findByID(Long id)
    {
        var endereco = super.findByID(id);
        return endereco.isPresent() ? endereco : Optional.empty();
    }

    public Optional<Endereco> validate(Endereco endereco)
    {
        var result = super.findByID(endereco.getId());
        return result.isPresent() ? result : this.repo.findByReferences(endereco.getLogradouroTipo(),
                endereco.getMoradiaTipo(), endereco.getComplementoTipo());
    }

    @Transactional
    public void addEdit(Endereco endereco) throws EnderecoServiceException
    {
        try
        {
            if (endereco.getId() == null)
            {
                super.create(endereco);
            }
            super.update(endereco);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
            throw new EnderecoServiceException("Erro ao gravar os dados do endereco", e);
        }
    }

}