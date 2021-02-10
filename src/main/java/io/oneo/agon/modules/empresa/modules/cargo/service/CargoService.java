package io.oneo.agon.modules.empresa.modules.cargo.service;

import io.oneo.agon.infra.service.BaseService;
import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.empresa.modules.cargo.mapper.CargoMapper;
import io.oneo.agon.modules.empresa.modules.cargo.model.Cargo;
import io.oneo.agon.modules.empresa.modules.cargo.repository.CargoRepository;
import io.oneo.agon.modules.empresa.modules.cargo.resource.dto.CargoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CargoService extends BaseService<Cargo, Long> implements ICargoService
{
    private final Logger logger = LoggerFactory.getLogger(CargoService.class);

    @Inject CargoRepository repo;

    @Inject CargoMapper mapper;

    public CargoMapper getMapper() { return this.mapper; }

    public Optional<Cargo> findByName(String name)
    {
        var cargo = this.repo.findByName(name);
        if (cargo.isPresent())
        {
            return cargo;
        }
        return  Optional.empty();
    }

    public Optional<Cargo> findByID(Long id)
    {
        if (id == null)
        {
            Optional.empty();
        }
        return super.findByID(id);
    }

    @Transactional
    public Cargo addEdit(Cargo cargo) throws BaseServiceException
    {
        try
        {
            if (cargo.getId() == null)
            {
                return this.create(cargo);
            }
            return this.update(cargo);
        }
        catch (Exception e)
        {
            this.logger.error(e.getMessage());
            throw new BaseServiceException("Erro ao gravar os dados do cargo", e);
        }
    }
}