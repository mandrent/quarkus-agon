package io.oneo.agon.modules.endereco.exception;

public class EnderecoServiceException extends RuntimeException
{
    public EnderecoServiceException() { super(); }

    public EnderecoServiceException(String message) { super(message); }

    public EnderecoServiceException(String message, Throwable cause) { super(message, cause); }

    public EnderecoServiceException(Throwable cause) { super(cause); }

    protected EnderecoServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}