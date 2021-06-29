package io.oneo.agon.modules.telefone.exception;

public class TelefoneServiceException extends RuntimeException
{
    public TelefoneServiceException() { super(); }

    public TelefoneServiceException(String message) { super(message); }

    public TelefoneServiceException(String message, Throwable cause) { super(message, cause); }

    public TelefoneServiceException(Throwable cause) { super(cause); }

    public TelefoneServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}