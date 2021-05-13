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

    public EnderecoMapper getMapper() { return this.mapper; }

    @Override
    public Optional<Endereco> findByID(Long id)
    {
        var endereco = super.findByID(id);
        if (!endereco.isPresent())
        {
            return Optional.empty();
        }
        return endereco;
    }

    @Transactional
    public Endereco addEdit(Endereco endereco) throws EnderecoServiceException
    {
        try
        {
            if (endereco.getId() == null)
            {
                return this.create(endereco);
            }
            return this.update(endereco);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
            throw new EnderecoServiceException("Erro ao gravar os dados do endereco", e);
        }
    }

}