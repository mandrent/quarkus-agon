package io.oneo.agon.modules.empresa.modules.funcionario.service;

import io.oneo.agon.modules.common.service.BaseService;
import io.oneo.agon.modules.empresa.modules.funcionario.exception.FuncionarioServiceException;
import io.oneo.agon.modules.empresa.modules.funcionario.mapper.FuncionarioMapper;
import io.oneo.agon.modules.empresa.modules.funcionario.model.Funcionario;
import io.oneo.agon.modules.empresa.modules.funcionario.repository.FuncionarioRepository;
import io.oneo.agon.modules.usuario.type.StatusUsuarioTipo;
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

    public FuncionarioMapper mapper() { return this.mapper; }

    public Optional<Funcionario> findByRegistration(String matricula)
    {
        return matricula.equals(null) ? Optional.empty() : this.repo.findByRegistration(matricula);
    }

    public Optional<Funcionario> findByFullname(String nome, String sobrenome)
    {
        return nome.equals(null) || sobrenome.equals(null) ?
                Optional.empty() : this.repo.findByFullname(nome, sobrenome);
    }

    private int validateDocuments(Funcionario funcionario)
    {
        if (funcionario.getRgdoc() != null)
        {
            return 1;
        }
        if (funcionario.getCpf() != null)
        {
            return 2;
        }
        if (funcionario.getCtps() != null)
        {
            return 3;
        }
        if (funcionario.getTitulo() != null)
        {
            return 4;
        }
        if (funcionario.getPis() != null)
        {
            return 5;
        }
        if (funcionario.getCnh() != null)
        {
            return 6;
        }
        if (funcionario.getReservista() != null)
        {
            return 7;
        }
        return 0;
    }

    private Optional<Funcionario> findByDocuments(Funcionario funcionario)
    {
        return switch (this.validateDocuments(funcionario)) {
            case 1 -> this.repo.findByRgdoc(funcionario.getRgdoc());
            case 2 -> this.repo.findByCPF(funcionario.getCpf());
            case 3 -> this.repo.findByCtps(funcionario.getCtps());
            case 4 -> this.repo.findByTitle(funcionario.getTitulo());
            case 5 -> this.repo.findByPIS(funcionario.getPis());
            case 6 -> this.repo.findByCNH(funcionario.getCnh());
            case 7 -> this.repo.findByReservista(funcionario.getReservista());
            default -> this.repo.findByPassaport(funcionario.getPassaporte());
        };
    }

    public Optional<Funcionario> validate(Funcionario funcionario)
    {
        if (funcionario.getId() != null)
        {
            return super.findByID(funcionario.getId());
        }

        if (!funcionario.getMatricula().equals(null))
        {
            return this.findByRegistration(funcionario.getMatricula());
        }

        if (!funcionario.getNome().equals(null) && !funcionario.getSobreNome().equals(null))
        {
            return this.repo.findByFullname(funcionario.getNome(), funcionario.getSobreNome());
        }

        var result = this.findByDocuments(funcionario);
        return result.isPresent() ? result : this.repo.findByPhone(funcionario.getTelefone());
    }

    @Transactional
    public void addEdit(Funcionario funcionario) throws FuncionarioServiceException
    {
        try
        {
            if (funcionario.getId() == null)
            {
                super.create(funcionario);
            }
            super.update(funcionario);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
            throw new FuncionarioServiceException("Erro ao gravar os dados do funcionário", e);
        }
    }



}