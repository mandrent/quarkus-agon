package io.oneo.agon.modules.arquivo.exception;

public class ArquivoServiceException extends RuntimeException
{
    public ArquivoServiceException() { super(); }

    public ArquivoServiceException(String message) { super(message); }

    public ArquivoServiceException(String message, Throwable cause) { super(message, cause); }

    public ArquivoServiceException(Throwable cause) { super(cause); }

    protected ArquivoServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}