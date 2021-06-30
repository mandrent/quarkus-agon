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
public class ProfissionalService extends BaseService<Profissional, Long> implements IProfissionalService
{
    private final Logger logger = LoggerFactory.getLogger(ProfissionalService.class);

    @Inject ProfissionalRepository repo;

    @Inject ProfissionalMapper mapper;

    public ProfissionalMapper getMapper() { return this.mapper; }

    @Override
    public Optional<Profissional> findByDocuments(Profissional profissional)
    {
        if (profissional.crea != null)
        {
            return this.repo.findByCrea(profissional.crea);
        }

        if (profissional.drt != null)
        {
            return this.repo.findByDRT(profissional.drt);
        }

        if (profissional.crm != null)
        {
            return this.repo.findByCRM(profissional.crm);
        }
        return this.repo.findByCoren(profissional.coren);
    }

    public Optional<Profissional> validate(Profissional profissional)
    {
        try
        {
            if (profissional.id != null)
            {
                return super.findByID(profissional.id);
            }

            if (profissional.usuario.id != null)
            {
                return this.repo.findByUser(profissional.usuario);
            }

            var result = this.repo.findByFullname(profissional.nome, profissional.sobreNome);
            return result.isPresent() ? result : this.repo.findByPhone(profissional.telefone);
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