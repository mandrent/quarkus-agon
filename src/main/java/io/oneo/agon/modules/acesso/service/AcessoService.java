package io.oneo.agon.modules.acesso.service;

import io.oneo.agon.infra.service.BaseService;
import io.oneo.agon.modules.acesso.model.Acesso;
import io.oneo.agon.modules.acesso.repository.AcessoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AcessoService extends BaseService<Acesso, Long> implements IAcessoService
{
    @Inject private AcessoRepository repo;


}