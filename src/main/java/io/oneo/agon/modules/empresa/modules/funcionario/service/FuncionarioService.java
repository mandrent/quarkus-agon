package io.oneo.agon.modules.empresa.modules.funcionario.service;

import io.oneo.agon.infra.service.BaseService;
import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.empresa.modules.cargo.service.CargoService;
import io.oneo.agon.modules.empresa.modules.funcionario.mapper.FuncionarioMapper;
import io.oneo.agon.modules.empresa.modules.funcionario.model.Funcionario;
import io.oneo.agon.modules.empresa.modules.funcionario.repository.FuncionarioRepository;
import io.oneo.agon.modules.empresa.modules.funcionario.resource.FuncionarioDTO;
import io.oneo.agon.modules.empresa.service.EmpresaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
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
    public Funcionario addEdit(Funcionario funcionario) throws BaseServiceException
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
            throw new BaseServiceException("Erro ao gravar os dados do funcionário", e);
        }
    }

    public Optional<Funcionario> findByRegistrationn(String matricula)
    {
        Optional<Funcionario> funcionario = this.repo.findByRegistrationn(matricula);
        if (!funcionario.isPresent())
        {
            Optional.empty();
        }
        return funcionario;
    }

}