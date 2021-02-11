package io.oneo.agon.modules.empresa.service;

import io.oneo.agon.infra.service.BaseService;
import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.empresa.mapper.EmpresaMapper;
import io.oneo.agon.modules.empresa.model.Empresa;
import io.oneo.agon.modules.empresa.repository.EmpresaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class EmpresaService extends BaseService<Empresa, Long> implements IEmpresaService
{
    private final Logger logger = LoggerFactory.getLogger(EmpresaService.class);

    @Inject EmpresaRepository repo;

    @Inject EmpresaMapper mapper;

    public EmpresaMapper getMapper() { return this.mapper; }

    public Optional<Empresa> findByCNPJ(String cnpj)
    {
        var empresa = this.repo.findByCNPJ(cnpj);
        if (empresa.isPresent())
        {
            this.logger.info("# retorna uma empresa pelo CNPJ #");
            return empresa;
        }
        return Optional.empty();
    }

    public Empresa addEdit(Empresa empresa) throws BaseServiceException
    {
        try
        {
            if (empresa.getId() == null)
            {
                return this.create(empresa);
            }
            return this.update(empresa);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
            throw new BaseServiceException("Erro ao gravar os dados do empresa!", e);
        }
    }
}