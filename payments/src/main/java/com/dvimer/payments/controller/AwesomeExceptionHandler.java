package com.dvimer.payments.controller;

import com.dvimer.payments.exception.AccountLessMoneyException;
import com.dvimer.payments.exception.AccountNotFoundException;
import com.dvimer.payments.exception.AwesomeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AwesomeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    protected ResponseEntity<AwesomeException> handleAccountNotFoundException(Exception e) {
        return new ResponseEntity<>(new AwesomeException(e.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AccountLessMoneyException.class)
    protected ResponseEntity<AwesomeException> handleLessMoneyException(Exception e) {
        return new ResponseEntity<>(new AwesomeException(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
