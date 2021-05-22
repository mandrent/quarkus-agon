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

    public CargoMapper mapper() { return this.mapper; }

    public Optional<Cargo> findByName(String name)
    {
        var cargo = this.repo.findByName(name);
        return cargo.isPresent() ? cargo : Optional.empty();
    }

    private Optional<Cargo> findByNameOrID(Cargo cargo)
    {
        var result = super.findByID(cargo.getId());
        return result.isPresent() ? result : this.findByName(cargo.getNome());
    }

    private Optional<Cargo> findByNameSectorOrFunction(Cargo cargo)
    {
        var result = this.repo.findByNameSectorFunction(cargo.getNome(), cargo.getSetor(), cargo.getFuncao());
        return result.isPresent() ? result : Optional.empty();
    }

    public Optional<Cargo> validate(Cargo cargo)
    {
        var result = this.findByNameOrID(cargo);
        return result.isPresent() ? result : this.findByNameSectorOrFunction(cargo);
    }

    @Transactional
    public void addEdit(Cargo cargo) throws CargoServiceException
    {
        try
        {
            if (cargo.getId() == null)
            {
                super.create(cargo);
            }
            super.update(cargo);
        }
        catch (Exception e)
        {
            this.logger.error(e.getMessage());
            throw new CargoServiceException("Erro ao gravar os dados do cargo", e);
        }
    }
}