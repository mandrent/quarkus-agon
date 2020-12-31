package io.oneo.agon.modules.funcionario.service;

import io.oneo.agon.infra.service.BaseService;
import io.oneo.agon.modules.funcionario.model.Funcionario;
import io.oneo.agon.modules.funcionario.repository.FuncionarioRepository;
import io.oneo.agon.modules.funcionario.support.dto.FuncionarioDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FuncionarioService extends BaseService<Funcionario, Long>
{
    @Inject FuncionarioRepository repo;

    public Funcionario salvar(FuncionarioDTO dto)
    {
        Funcionario funcionario = this.convertOne(dto, Funcionario.class);
        this.criar(funcionario);
        return funcionario;
    }



}