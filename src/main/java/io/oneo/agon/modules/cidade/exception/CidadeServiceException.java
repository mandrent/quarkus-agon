package io.oneo.agon.modules.cidade.exception;

public class CidadeServiceException extends RuntimeException
{
    public CidadeServiceException() { super(); }

    public CidadeServiceException(String message) { super(message); }

    public CidadeServiceException(String message, Throwable cause) { super(message, cause); }

    public CidadeServiceException(Throwable cause) { super(cause); }

    public CidadeServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}