package io.oneo.agon.modules.empresa.modules.funcionario.service;

import io.oneo.agon.modules.common.service.BaseService;
import io.oneo.agon.modules.empresa.modules.funcionario.exception.FuncionarioServiceException;
import io.oneo.agon.modules.empresa.modules.funcionario.mapper.FuncionarioMapper;
import io.oneo.agon.modules.empresa.modules.funcionario.model.Funcionario;
import io.oneo.agon.modules.empresa.modules.funcionario.repository.FuncionarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

@ApplicationScoped
public class FuncionarioService extends BaseService<Funcionario, Long> implements IFuncionarioService
{
    private final Logger logger = LoggerFactory.getLogger(FuncionarioService.class);

    @Inject FuncionarioRepository repo;

    @Inject FuncionarioMapper mapper;

    public FuncionarioMapper getMapper() { return this.mapper; }

    public Optional<Funcionario> findByID(Long id)
    {
        Optional<Funcionario> funcionario = super.findByID(id);
        if (!funcionario.isPresent())
        {
            Optional.empty();
        }
        return funcionario;
    }

    @Transactional
    public Funcionario addEdit(Funcionario funcionario) throws FuncionarioServiceException
    {
        try
        {
            if (funcionario.getId() == null)
            {
                return this.create(funcionario);
            }
            return this.update(funcionario);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
            throw new FuncionarioServiceException("Erro ao gravar os dados do funcionário", e);
        }
    }

    public Optional<Funcionario> findByRegistrationn(String matricula)
    {
        if (matricula.equalsIgnoreCase(null))
        {
            Optional<Funcionario> funcionario = this.repo.findByRegistrationn(matricula);
            return funcionario.isPresent() ? funcionario : Optional.empty();
        }
        return Optional.empty();
    }



}