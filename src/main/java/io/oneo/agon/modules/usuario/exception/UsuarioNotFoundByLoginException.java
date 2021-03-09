package io.oneo.agon.modules.usuario.exception;

public class UsuarioNotFoundByLoginException extends RuntimeException
{
    public UsuarioNotFoundByLoginException() { super(); }

    public UsuarioNotFoundByLoginException(String message) { super(message); }

    public UsuarioNotFoundByLoginException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public UsuarioNotFoundByLoginException(Throwable cause) { super(cause); }

    protected UsuarioNotFoundByLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}