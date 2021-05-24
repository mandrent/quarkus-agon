package io.oneo.agon.modules.profissional.service;

import io.oneo.agon.modules.common.service.BaseService;
import io.oneo.agon.modules.profissional.exception.ProfissionalServiceException;
import io.oneo.agon.modules.profissional.mapper.ProfissionalMapper;
import io.oneo.agon.modules.profissional.model.Profissional;
import io.oneo.agon.modules.profissional.repository.ProfissionalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

@ApplicationScoped
public class ProfissionalService extends BaseService<Profissional, Long>
{
    private final Logger logger = LoggerFactory.getLogger(ProfissionalService.class);

    @Inject ProfissionalRepository repo;

    @Inject ProfissionalMapper mapper;

    public ProfissionalMapper mapper() { return this.mapper; }

    private int validateRegistration(Profissional profissional)
    {
        if (!profissional.getDrt().equals(null))
        {
            return 1;
        }

        if (!profissional.getCrm().equals(null))
        {
            return 2;
        }

        if (!profissional.getCrea().equals(null))
        {
            return 3;
        }
        return 0;
    }

    public Optional<Profissional> findByRegistration(Profissional profissional)
    {
        return switch (this.validateRegistration(profissional)) {
            case 1 -> this.repo.findByDRT(profissional.getDrt());
            case 2 -> this.repo.findByCRM(profissional.getCrm());
            case 3 -> this.repo.findByCrea(profissional.getCrea());
            default -> this.repo.findByCoren(profissional.getCoren());
        };
    }

    public Optional<Profissional> validate(Profissional profissional) throws ProfissionalServiceException
    {
        try
        {
            if (profissional.getId() != null)
            {
                return super.findByID(profissional.getId());
            }

            if (profissional.getUsuario() != null)
            {
                return this.repo.findByUser(profissional.getUsuario());
            }

            if (!profissional.getNome().equals(null) && !profissional.getSobreNome().equals(null))
            {
                return this.repo.findByFullname(profissional.getNome(), profissional.getSobreNome());
            }
            var result = this.findByRegistration(profissional);
            return result.isPresent() ? result : this.repo.findByPhone(profissional.getTelefone());
        }
        catch (Exception e)
        {
            this.logger.error(e.getMessage());
            throw new ProfissionalServiceException("Erro ao validar o funcionario", e);
        }
    }

    @Transactional
    public void addEdit(Profissional profissional) throws ProfissionalServiceException
    {
        try
        {
            if (profissional.getId() == null)
            {
                super.create(profissional);
            }
            super.update(profissional);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
            throw new ProfissionalServiceException("Erro ao gravar os dados do usuário", e);
        }
    }
}