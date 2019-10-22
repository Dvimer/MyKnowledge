package com.dvimer.payments.service;

import com.dvimer.payments.entity.Account;
import org.springframework.transaction.annotation.Transactional;

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
}
