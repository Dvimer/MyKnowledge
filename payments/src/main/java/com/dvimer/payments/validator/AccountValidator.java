package com.dvimer.payments.validator;

import com.dvimer.payments.entity.Account;
import com.dvimer.payments.exception.AccountLessMoneyException;

import java.math.BigDecimal;

public class AccountValidator {
    public static void validate(Account account) {
        if (account.getAmount() != null && account.getAmount().compareTo(BigDecimal.ZERO) < 0)
            throw new AccountLessMoneyException();
    }
}
