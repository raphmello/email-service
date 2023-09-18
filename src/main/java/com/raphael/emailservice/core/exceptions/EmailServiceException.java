package com.raphael.emailservice.core.exceptions;

public class EmailServiceException extends RuntimeException {
    public EmailServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
