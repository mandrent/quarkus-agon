package io.oneo.agon.modules.profissional.exception;

public class ProfissionalServiceException extends RuntimeException
{
    public ProfissionalServiceException() { }

    public ProfissionalServiceException(String message) { super(message); }

    public ProfissionalServiceException(String message, Throwable cause) { super(message, cause); }

    public ProfissionalServiceException(Throwable cause) { super(cause); }

    public ProfissionalServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}