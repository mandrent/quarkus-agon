package io.oneo.agon.modules.empresa.modules.cargo.exception;

public class CargoServiceException extends RuntimeException
{
    public CargoServiceException() { super(); }

    public CargoServiceException(String message) { super(message); }

    public CargoServiceException(String message, Throwable cause) { super(message, cause); }

    public CargoServiceException(Throwable cause) { super(cause); }

    protected CargoServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}