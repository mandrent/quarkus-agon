package io.oneo.agon.infra.service;

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
        logger.info("# salvando nova entidade #");
        this.repo.persist(t);
        return t;
    }

    @Override
    public T update(T t)
    {
        logger.info("# atualizando entidade # ");
        this.repo.getEntityManager().merge(t);
        return t;
    }

    @Override
    public Optional<T> findByID(ID id)
    {
        if (id == null)
        {
            this.logger.info("# objeto naun encontrado pelo ID #");
            return Optional.empty();
        }
        this.logger.info("# retorna objeto pelo ID #");
        return this.repo.findByIdOptional(id);
    }

    @Override
    public void remove(T t)
    {
        logger.info("# removendo a entidade #");
        this.repo.delete(t);
    }

    @Override
    public void removeByID(ID id)
    {
        logger.info("# removendo uma entidade pelo ID #");
        this.repo.deleteById(id);
    }

    @Override
    public List<T> list()
    {
        logger.info("# listando todos os objetos #");
        return this.repo.listAll();
    }





}