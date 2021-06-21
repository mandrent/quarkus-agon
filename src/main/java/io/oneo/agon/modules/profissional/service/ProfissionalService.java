package io.oneo.agon.modules.profissional.service;

import io.oneo.agon.modules.common.service.BaseService;
import io.oneo.agon.modules.profissional.exception.ProfissionalServiceException;
import io.oneo.agon.modules.profissional.mapper.ProfissionalMapper;
import io.oneo.agon.modules.profissional.model.Profissional;
import io.oneo.agon.modules.profissional.repository.ProfissionalRepository;
import io.oneo.agon.modules.profissional.resource.dto.ProfissionalDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProfissionalService extends BaseService<Profissional, Long> implements IProfissionalService
{
    private final Logger logger = LoggerFactory.getLogger(ProfissionalService.class);

    @Inject ProfissionalRepository repo;

    @Inject ProfissionalMapper mapper;

    public ProfissionalMapper getMapper() { return this.mapper; }

    @Override
    public Optional<Profissional> findByDocuments(Profissional profissional)
    {
        if (profissional.getCrea() != null)
        {
            return this.repo.findByCrea(profissional.getCrea());
        }

        if (profissional.getDrt() != null)
        {
            return this.repo.findByDRT(profissional.getDrt());
        }

        if (profissional.getCrm() != null)
        {
            return this.repo.findByCRM(profissional.getCrm());
        }
        return this.repo.findByCoren(profissional.getCoren());
    }

    public Optional<Profissional> validate(Profissional profissional)
    {
        try
        {
            if (profissional.id != null)
            {
                return super.findByID(profissional.id);
            }

            if (profissional.getUsuario().id != null)
            {
                return this.repo.findByUser(profissional.getUsuario());
            }

            var result = this.repo.findByFullname(profissional.getNome(), profissional.getSobreNome());
            return result.isPresent() ? result : this.repo.findByPhone(profissional.getTelefone());
        }
        catch (Exception e)
        {
            this.logger.error(e.getMessage());
            throw new ProfissionalServiceException("Erro ao validar o funcionario", e);
        }
    }

    @Transactional
    public void addEdit(Profissional profissional)
    {
        try
        {
            if (profissional.id == null)
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