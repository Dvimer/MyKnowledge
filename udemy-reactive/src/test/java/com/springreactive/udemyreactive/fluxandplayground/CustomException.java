package com.springreactive.udemyreactive.fluxandplayground;

public class CustomException extends RuntimeException {
    private String message;

    public CustomException(Throwable cause) {
        this.message = cause.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
