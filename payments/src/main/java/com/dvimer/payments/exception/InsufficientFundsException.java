package com.dvimer.payments.exception;

public class InsufficientFundsException extends RuntimeException {
    private static final String INSUFFICIENT_FUNDS = "INSUFFICIENT_FUNDS";


    public InsufficientFundsException() {
        super(INSUFFICIENT_FUNDS);
    }

    public InsufficientFundsException(Throwable cause) {
        super(cause);
    }
}
