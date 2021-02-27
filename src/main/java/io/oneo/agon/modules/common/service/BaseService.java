package io.oneo.agon.modules.common.service;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseService<T extends Serializable, ID extends Serializable> implements IService<T, ID>
{
    private final Logger logger = LoggerFactory.getLogger(BaseService.class);

    @Inject PanacheRepositoryBase<T, ID> repo;

    @Override
    public T create(T t)
    {
        this.repo.persist(t);
        this.logger.info("# salvando nova entidade #");
        return t;
    }

    @Override
    public T update(T t)
    {
        this.repo.getEntityManager().merge(t);
        this.logger.info("# atualizando entidade # ");
        return t;
    }

    @Override
    public Optional<T> findByID(ID id)
    {
        if (id == null)
        {
            this.logger.info("# objeto naun localizado pelo ID #");
            return Optional.empty();
        }
        this.logger.info("# retornando objeto pelo ID #");
        return this.repo.findByIdOptional(id);
    }

    @Override
    public void remove(T t)
    {
        this.repo.delete(t);
        this.logger.info("# removendo a entidade #");
    }

    @Override
    public void removeByID(ID id)
    {
        this.repo.deleteById(id);
        this.logger.info("# removendo uma entidade pelo ID #");
    }

    @Override
    public List<T> list()
    {
        this.logger.info("# listando todos os objetos #");
        return this.repo.listAll();
    }





}