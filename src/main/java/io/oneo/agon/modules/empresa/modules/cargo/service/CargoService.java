package io.oneo.agon.modules.empresa.modules.cargo.service;

import io.oneo.agon.modules.common.service.BaseService;
import io.oneo.agon.modules.empresa.modules.cargo.exception.CargoServiceException;
import io.oneo.agon.modules.empresa.modules.cargo.mapper.CargoMapper;
import io.oneo.agon.modules.empresa.modules.cargo.model.Cargo;
import io.oneo.agon.modules.empresa.modules.cargo.repository.CargoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
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

    @Transactional
    public Cargo addEdit(Cargo cargo) throws CargoServiceException
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
            throw new CargoServiceException("Erro ao gravar os dados do cargo", e);
        }
    }
}