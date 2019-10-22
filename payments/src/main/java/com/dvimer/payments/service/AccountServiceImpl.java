package com.dvimer.payments.service;

import com.dvimer.payments.dao.AccountRepository;
import com.dvimer.payments.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository repository;

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Account> findByNumber(long number) {
        return repository.findByNumber(number);
    }

    @Override
    public void save(Account account) {
        repository.save(account);
    }

    @Override
    public void saveAll(Set<Account> accounts) {
        repository.saveAll(accounts);
    }
}
