package io.oneo.agon.infra.producer.jooq;

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
    @Inject AgroalDataSource ads;

    @Produces
    DSLContext getContext() { return DSL.using(this.ads, SQLDialect.MYSQL); }
}