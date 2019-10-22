package com.dvimer.payments.mapper;

import com.dvimer.payments.domain.AccountInfo;
import com.dvimer.payments.entity.Account;

public class AccountToAccountRestMapper {
    public static Account map(AccountInfo accountRest) {
        Account account = new Account();
        account.setAmount(accountRest.getAmount());
        account.setNumber(accountRest.getNumber());
        return account;
    }
}
