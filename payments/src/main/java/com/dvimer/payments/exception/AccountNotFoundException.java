package com.dvimer.payments.exception;

public class AccountNotFoundException extends RuntimeException{
    private static final String NOT_FOUND = "Not found";

    public AccountNotFoundException() {
        super(NOT_FOUND);
    }

    public AccountNotFoundException(Throwable cause) {
        super(cause);
    }
}
