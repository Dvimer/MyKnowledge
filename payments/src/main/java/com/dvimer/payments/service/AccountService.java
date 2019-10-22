package com.dvimer.payments.service;

import com.dvimer.payments.domain.AccountInfo;
import com.dvimer.payments.entity.Account;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AccountService {
    @Transactional
    List<Account> findAll();

    @Transactional
    Optional<Account> findByNumber(long number);

    @Transactional
    void save(Account account);

    @Transactional
    void saveAll(Set<Account> accounts);

    void deposit(AccountInfo accountInfo);

    @Transactional
    void withdraw(AccountInfo accountInfo);

    @Transactional
    void transferMoney(Account fromAcct,
                       Account toAcct,
                       BigDecimal amount);
}
