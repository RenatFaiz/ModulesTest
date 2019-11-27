package ru.itpark.exception;

public class DemoException extends RuntimeException {
    public DemoException() {
        super();
    }

    public DemoException(String message) {
        super(message);
    }

    public DemoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DemoException(Throwable cause) {
        super(cause);
    }

    protected DemoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
