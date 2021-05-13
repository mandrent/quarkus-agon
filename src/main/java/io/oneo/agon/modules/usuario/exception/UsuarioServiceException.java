package io.oneo.agon.modules.usuario.exception;

public class UsuarioServiceException extends RuntimeException
{
    public UsuarioServiceException() { super(); }

    public UsuarioServiceException(String message) { super(message); }

    public UsuarioServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public UsuarioServiceException(Throwable cause) { super(cause); }

    protected UsuarioServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}