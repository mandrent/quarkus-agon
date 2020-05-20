package io.oneo.agon.modules.common.producer;

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
    @Inject private AgroalDataSource ads;

    @Produces
    public DSLContext getContext()
    {
        return DSL.using(this.ads, SQLDialect.MYSQL);
    }
}