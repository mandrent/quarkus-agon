package io.oneo.agon.modules.empresa.modules.funcionario.exception;

public class FuncionarioServiceException extends RuntimeException
{
    public FuncionarioServiceException() { super(); }

    public FuncionarioServiceException(String message) { super(message); }

    public FuncionarioServiceException(String message, Throwable cause) { super(message, cause); }

    public FuncionarioServiceException(Throwable cause) { super(cause); }

    protected FuncionarioServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}