package io.oneo.agon.modules.funcionario.service;

import io.oneo.agon.infra.service.BaseService;
import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.funcionario.model.Funcionario;
import io.oneo.agon.modules.funcionario.repository.FuncionarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

@ApplicationScoped
public class FuncionarioService extends BaseService<Funcionario, Long>
{
    private final Logger logger = LoggerFactory.getLogger(FuncionarioService.class);

    @Inject FuncionarioRepository repo;

    public Optional<Funcionario> findByID(Long id)
    {
        return this.buscarPorID(id);
    }

    @Transactional
    public void addEdit(Funcionario funcionario) throws BaseServiceException
    {
        try
        {
            if (funcionario.getId() == null)
            {
                this.criar(funcionario);
            }
            this.atualizar(funcionario);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
            throw new BaseServiceException("Erro ao gravar os dados do usuário", e);
        }
    }

    public Optional<Funcionario> findByRegistrationn(String matricula)
    {
        return this.repo.findByRegistrationn(matricula);
    }




}