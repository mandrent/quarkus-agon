package io.oneo.agon.modules.usuario.service;

import io.oneo.agon.modules.common.exception.BaseServiceException;
import io.oneo.agon.modules.common.service.BaseService;
import io.oneo.agon.modules.usuario.exception.UsuarioNotFoundByLoginException;
import io.oneo.agon.modules.usuario.mapper.UsuarioMapper;
import io.oneo.agon.modules.usuario.model.Usuario;
import io.oneo.agon.modules.usuario.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

@ApplicationScoped
public class UsuarioService extends BaseService<Usuario, Long> implements IUsuarioService
{
    private final Logger log = LoggerFactory.getLogger(UsuarioService.class);

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
                return this.create(usuario);
            }
            return this.update(usuario);
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            throw new BaseServiceException("Erro ao gravar os dados do usuário", e);
        }
    }

    /*
    private Usuario validarGrupoStatus(Usuario usuario, Integer grupoValor, Integer statusValor)
    {
        var grupo = switch (grupoValor)
                {
                    case 1 -> GrupoTipo.ADMIN;
                    case 2 -> GrupoTipo.CONVIDADO;
                    case 3 -> GrupoTipo.EMPRESA;
                    default -> GrupoTipo.PROFISSIONAL;
                };

        var status = switch (statusValor)
            {
                case 1 -> StatusUsuarioTipo.ATIVO;
                case 2 -> StatusUsuarioTipo.INATIVO;
                default -> StatusUsuarioTipo.PENDENTE;
            };

        usuario.setGrupo(grupo);
        usuario.setStatus(status);
        return usuario;
    }

     */

    public Optional<Usuario> findByLogin(String login) throws UsuarioNotFoundByLoginException
    {
        try
        {
            var usuario = this.repo.buscarPorLogin(login);
            if (!usuario.isPresent())
            {
                return Optional.empty();
            }
            return usuario;
        }
        catch (Exception e)
        {
            this.log.error(e.getMessage());
            throw new UsuarioNotFoundByLoginException("Erro ao buscar usuario pelo login", e);
        }
    }



}