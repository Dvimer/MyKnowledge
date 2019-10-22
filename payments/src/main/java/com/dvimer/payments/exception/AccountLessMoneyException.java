package com.dvimer.payments.exception;

public class AccountLessMoneyException extends RuntimeException {
    private static final String LESS_ZERO = "Less zero";


    public AccountLessMoneyException() {
        super(LESS_ZERO);
    }

    public AccountLessMoneyException(Throwable cause) {
        super(cause);
    }
}
