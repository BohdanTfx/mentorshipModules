package com.epam.mentorship.exception;

public class DatabaseException extends RuntimeException {
    private static final long serialVersionUID = 5355045290404423029L;

    public DatabaseException() {
        super();
    }

    public DatabaseException(final String message, final Throwable cause,
            final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DatabaseException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DatabaseException(final String message) {
        super(message);
    }

    public DatabaseException(final Throwable cause) {
        super(cause);
    }

}
