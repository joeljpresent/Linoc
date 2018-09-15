package io.github.joeljpresent.linoc.exceptions;

public class ColorAlreadyPresentException extends LinocException
{
    public ColorAlreadyPresentException()
    {
        super();
    }

    public ColorAlreadyPresentException(String message)
    {
        super(message);
    }

    public ColorAlreadyPresentException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ColorAlreadyPresentException(Throwable cause)
    {
        super(cause);
    }

    protected ColorAlreadyPresentException(String message, Throwable cause,
                                           boolean enableSuppression,
                                           boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
