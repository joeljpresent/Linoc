package io.github.joeljpresent.linoc.exceptions;

import java.awt.*;

/**
 * Every exception specific to Linoc shall extends this class.
 */
abstract public class LinocException extends Exception
{
    public LinocException()
    {
        super();
    }

    public LinocException(String message)
    {
        super(message);
    }

    public LinocException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public LinocException(Throwable cause)
    {
        super(cause);
    }

    protected LinocException(String message, Throwable cause,
                             boolean enableSuppression,
                             boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
