package io.oneo.agon.modules.empresa.service;

import io.oneo.agon.modules.common.service.BaseService;
import io.oneo.agon.modules.empresa.exception.EmpresaServiceException;
import io.oneo.agon.modules.empresa.mapper.EmpresaMapper;
import io.oneo.agon.modules.empresa.model.Empresa;
import io.oneo.agon.modules.empresa.repository.EmpresaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
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
        if (cnpj.equalsIgnoreCase(null))
        {
            this.logger.info("# empresa naun localizada pelo CNPJ #");
            return Optional.empty();
        }
        this.logger.info("# retornando empresa pelo CNPJ #");
        return this.repo.findByCNPJ(cnpj);
    }

    @Transactional
    public Empresa addEdit(Empresa empresa) throws EmpresaServiceException
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
            this.logger.error(e.getMessage());
            throw new EmpresaServiceException("Erro ao gravar os dados do empresa", e);
        }
    }

}