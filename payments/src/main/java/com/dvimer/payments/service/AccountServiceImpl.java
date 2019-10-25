package com.dvimer.payments.service;

import com.dvimer.payments.dao.AccountRepository;
import com.dvimer.payments.domain.AccountInfo;
import com.dvimer.payments.entity.Account;
import com.dvimer.payments.exception.AccountLessMoneyException;
import com.dvimer.payments.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository repository;
    private static final Object tieLock = new Object();
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

    @Override
    @Transactional
    public synchronized void deposit(AccountInfo accountInfo) {
        Account currentAccount = findByNumber(accountInfo.getNumber()).orElseThrow(AccountNotFoundException::new);
        currentAccount.setAmount(currentAccount.getAmount().add(accountInfo.getAmount()));
        save(currentAccount);
    }

    @Override
    public synchronized void withdraw(AccountInfo accountInfo) {
        Account currentAccount = findByNumber(accountInfo.getNumber()).orElseThrow(AccountNotFoundException::new);
        substructAmount(currentAccount, accountInfo.getAmount());
        save(currentAccount);
    }

    @Override
    public void transferMoney(final Account fromAcct,
                              final Account toAcct,
                              final BigDecimal amount) {
        class Helper {
            public void transfer() throws AccountLessMoneyException {
                if (fromAcct.getAmount().compareTo(amount) < 0)
                    throw new AccountLessMoneyException();
                else {
                    substructAmount(fromAcct, amount);
                    toAcct.setAmount(toAcct.getAmount().add(amount));
                    HashSet<Account> set = new HashSet<>();
                    set.add(fromAcct);
                    set.add(toAcct);
                    saveAll(set);
                }
            }
        }
        int fromHash = System.identityHashCode(fromAcct);
        int toHash = System.identityHashCode(toAcct);
        if (fromHash < toHash) {
            synchronized (fromAcct) {
                synchronized (toAcct) {
                    new Helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (toAcct) {
                synchronized (fromAcct) {
                    new Helper().transfer();
                }
            }
        } else {
            synchronized (tieLock) {
                synchronized (fromAcct) {
                    synchronized (toAcct) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }

    private void substructAmount(Account currentAccount, BigDecimal amount) {
        BigDecimal subtract = currentAccount.getAmount().subtract(amount);
        if (subtract.compareTo(BigDecimal.ZERO) < 0) {
            throw new AccountLessMoneyException();
        }
        currentAccount.setAmount(subtract);
    }

}
