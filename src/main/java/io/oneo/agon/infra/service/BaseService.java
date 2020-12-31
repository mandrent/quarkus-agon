package io.oneo.agon.infra.service;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.jooq.DSLContext;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseService<T extends Serializable, ID extends Serializable> implements IService<T, ID>
{
    private final Logger logger = LoggerFactory.getLogger(BaseService.class);

    @Inject PanacheRepositoryBase<T, ID> repo;

    @Inject protected DSLContext dsl;

    private ModelMapper mapper = new ModelMapper();

    public BaseService() { }

    @Override
    public void criar(T t)
    {
        logger.info("# salvando uma nova entidade #");
        this.repo.persist(t);
    }

    @Override
    public T atualizar(T t)
    {
        logger.info("# atualizando os dados do objeto #");
        this.repo.getEntityManager().merge(t);
        return t;
    }

    @Override
    public Optional<T> buscarPorID(ID id)
    {
        logger.info("# retornando um objeto pelo ID #");
        return this.repo.findByIdOptional(id);
    }

    @Override
    public void remover(T t)
    {
        logger.info("# removendo a entidade #");
        this.repo.delete(t);
    }

    @Override
    public void removerPorID(ID id)
    {
        logger.info("# removendo uma entidade pelo ID #");
        this.repo.deleteById(id);
    }

    @Override
    public List<T> listar()
    {
        logger.info("# listando todos os objetos #");
        return this.repo.listAll();
    }

    @Override
    public <T> T convertOne(Object source, Class<T> target)
    {
        return source == null ? null : this.mapper.map(source, target);
    }

    @Override
    public <D, T> List<D> convertList(final Collection<T> sourceList, Class<D> target)
    {
        this.logger.info("# conversão de uma lista objetos #");
        return sourceList.size() > 0 ? sourceList.stream()
                .map(source -> this.mapper.map(source, target))
                .collect(Collectors.toList()) : new ArrayList<>();
    }



}