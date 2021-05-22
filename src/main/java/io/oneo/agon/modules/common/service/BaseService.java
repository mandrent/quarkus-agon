package io.oneo.agon.modules.common.service;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseService<E extends Serializable, ID extends Serializable> implements IService<E, ID>
{
    private final Logger logger = LoggerFactory.getLogger(BaseService.class);

    @Inject PanacheRepositoryBase<E, ID> repo;

    @Inject DSLContext dsl;

    public DSLContext dsl() { return this.dsl; }

    @Override
    public void create(E t)
    {
        this.repo.persist(t);
        this.logger.info("# add entidade #");
    }

    @Override
    public void update(E t)
    {
        this.repo.getEntityManager().merge(t);
        this.logger.info("# update entidade # ");
    }

    @Override
    public Optional<E> findByID(ID id)
    {
        this.logger.info("# retornando objeto pelo ID #");
        return this.repo.findByIdOptional(id);
    }

    @Override
    public void remove(E t)
    {
        this.repo.delete(t);
        this.logger.info("# remove entidade #");
    }

    @Override
    public void removeByID(ID id)
    {
        this.repo.deleteById(id);
        this.logger.info("# remove por ID #");
    }

    @Override
    public List<E> list()
    {
        this.logger.info("# lista entidades #");
        return this.repo.listAll();
    }

}