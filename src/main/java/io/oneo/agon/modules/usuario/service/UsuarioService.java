package io.oneo.agon.modules.usuario.service;

import io.oneo.agon.modules.common.service.BaseService;
import io.oneo.agon.modules.usuario.exception.UsuarioServiceException;
import io.oneo.agon.modules.usuario.mapper.UsuarioMapper;
import io.oneo.agon.modules.usuario.model.Usuario;
import io.oneo.agon.modules.usuario.repository.UsuarioRepository;
import io.oneo.agon.modules.usuario.type.GrupoTipo;
import io.oneo.agon.modules.usuario.type.StatusUsuarioTipo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.lang.String.valueOf;

@ApplicationScoped
public class UsuarioService extends BaseService<Usuario, Long> implements IUsuarioService
{
    private final Logger log = LoggerFactory.getLogger(UsuarioService.class);

    @Inject UsuarioRepository repo;

    @Inject UsuarioMapper mapper;

    public UsuarioMapper mapper() { return this.mapper; }

    @Override
    public GrupoTipo validateGroup(Integer grupoValor)
    {
        return switch (grupoValor) {
            case 1 -> GrupoTipo.ADMIN;
            case 2 -> GrupoTipo.CONVIDADO;
            case 3 -> GrupoTipo.EMPRESA;
            default -> GrupoTipo.PROFISSIONAL;
        };
    }

    @Override
    public StatusUsuarioTipo validateStatus(Integer statusValor)
    {
        return switch (statusValor) {
            case 1 -> StatusUsuarioTipo.ATIVO;
            case 2 -> StatusUsuarioTipo.INATIVO;
            default -> StatusUsuarioTipo.PENDENTE;
        };
    }

    @Override
    public Optional<Usuario> findByLogin(String login) throws UsuarioServiceException
    {
        try
        {
            return login.equals(null) ? Optional.empty() : this.repo.findByLogin(login);
        }
        catch (Exception e)
        {
            this.log.error(e.getMessage());
            throw new UsuarioServiceException("Erro ao buscar usuario pelo login", e);
        }
    }

    @Override
    public Optional<Usuario> findByEmail(String email) throws UsuarioServiceException
    {
        try
        {
            return email.equals(null) ? Optional.empty() : this.repo.findByEmail(email);
        }
        catch (Exception e)
        {
            this.log.error(e.getMessage());
            throw new UsuarioServiceException("Erro ao buscar usuario pelo email", e);
        }
    }

    public Optional<Usuario> validate(Usuario usuario) throws UsuarioServiceException
    {
        try
        {
            var result = this.findByLogin(usuario.getLogin());
            result = !result.isPresent() ? this.findByEmail(usuario.getEmail()) : result;
            return result.isPresent() ? result : super.findByID(usuario.id);
        }
        catch (Exception e)
        {
            this.log.error(e.getMessage());
            throw new UsuarioServiceException("Erro ao buscar usuario", e);
        }
    }

    public List<Usuario> listByGroup(Integer grupoID) { return this.repo.listByGrupo(this.validateGroup(grupoID)); }

    public List<Usuario> listByStatus(Integer statusID)
    {
        return this.repo.listByStatus(this.validateStatus(statusID));
    }

    @Transactional
    public void addEdit(Usuario usuario) throws UsuarioServiceException
    {
        try
        {
            if (usuario.id == null)
            {
                usuario.setGrupo(this.validateGroup(usuario.getGrupo().ordinal()));
                usuario.setStatus(this.validateStatus(usuario.getStatus().ordinal()));
                super.create(usuario);
            }
            super.update(usuario);
        }
        catch (Exception e)
        {
            this.log.error(e.getMessage());
            throw new UsuarioServiceException("Erro ao gravar os dados do usuário", e);
        }
    }



}