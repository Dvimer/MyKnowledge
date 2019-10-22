package com.dvimer.payments.dao;

import com.dvimer.payments.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Integer> {
    List<Account> findAll();

    Optional<Account> findByNumber(long number);

}
