package io.oneo.agon.modules.empresa.exception;

public class EmpresaServiceException extends RuntimeException
{
    public EmpresaServiceException() { super(); }

    public EmpresaServiceException(String message) { super(message); }

    public EmpresaServiceException(String message, Throwable cause) { super(message, cause); }

    public EmpresaServiceException(Throwable cause) { super(cause); }

    protected EmpresaServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}