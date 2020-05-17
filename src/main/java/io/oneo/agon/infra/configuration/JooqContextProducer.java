package io.oneo.agon.infra.configuration;

import io.agroal.api.AgroalDataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@Dependent
public class JooqContextProducer
{
    @Inject
    private AgroalDataSource dataSource;

    @Produces
    public DSLContext dslContext()
    {
        return DSL.using(dataSource, SQLDialect.POSTGRES);
    }
}