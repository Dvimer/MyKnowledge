package com.dvimer.payments.exception;

public class AwesomeException {
    public AwesomeException() {
    }

    public AwesomeException(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
