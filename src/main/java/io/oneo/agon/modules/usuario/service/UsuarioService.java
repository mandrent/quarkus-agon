package io.oneo.agon.modules.usuario.service;

import io.oneo.agon.infra.service.BaseService;
import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.usuario.mapper.UsuarioMapper;
import io.oneo.agon.modules.usuario.model.Usuario;
import io.oneo.agon.modules.usuario.repository.UsuarioRepository;
import io.oneo.agon.modules.usuario.resource.dto.UsuarioDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UsuarioService extends BaseService<Usuario, Long> implements IUsuarioService
{
    private final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Inject UsuarioRepository repo;

    @Inject UsuarioMapper mapper;

    public UsuarioMapper getMapper() { return this.mapper; }

    @Transactional
    public Usuario addEdit(Usuario usuario) throws BaseServiceException
    {
        try
        {
            if (usuario.getId() == null)
            {
                this.create(usuario);
                return usuario;
            }
            return this.update(usuario);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
            throw new BaseServiceException("Erro ao gravar os dados do usuário", e);
        }
    }

    public Optional<Usuario> findByLogin(String login)
    {
        Optional<Usuario> usuario = this.repo.findByLogin(login);
        if (!usuario.isPresent())
        {
            return Optional.empty();
        }
        return usuario;
    }

    public Optional<Usuario> findByID(Long id)
    {
        Optional<Usuario> usuario = super.findByID(id);
        if (!usuario.isPresent())
        {
            return Optional.empty();
        }
        return usuario;
    }



}