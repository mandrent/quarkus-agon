package io.oneo.agon.modules.telefone.exception;

public class TelefoneException extends RuntimeException
{
    public TelefoneException() { super(); }

    public TelefoneException(String message) { super(message); }

    public TelefoneException(String message, Throwable cause) { super(message, cause); }

    public TelefoneException(Throwable cause) { super(cause); }

    public TelefoneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}