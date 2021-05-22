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

    public EmpresaMapper mapper() { return this.mapper; }

    public Optional<Empresa> findByCNPJ(String cnpj)
    {
        var empresa = this.repo.findByCNPJ(cnpj);
        this.logger.info("# retornando empresa pelo CNPJ #");
        return empresa.isPresent() ? empresa : Optional.empty();
    }

    public Optional<Empresa> validate(Empresa empresa)
    {
        var result = super.findByID(empresa.getId());
        return result.isPresent() ? result : this.findByCNPJ(empresa.getCnpj());
    }

    @Transactional
    public void addEdit(Empresa empresa) throws EmpresaServiceException
    {
        try
        {
            if (empresa.getId() == null)
            {
                super.create(empresa);
            }
            super.update(empresa);
        }
        catch (Exception e)
        {
            this.logger.error(e.getMessage());
            throw new EmpresaServiceException("Erro ao gravar os dados do empresa", e);
        }
    }

}