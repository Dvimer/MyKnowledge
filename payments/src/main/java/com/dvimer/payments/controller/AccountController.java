package com.dvimer.payments.controller;

import com.dvimer.payments.domain.AccountInfo;
import com.dvimer.payments.domain.TransactionMoney;
import com.dvimer.payments.entity.Account;
import com.dvimer.payments.exception.AccountLessMoneyException;
import com.dvimer.payments.exception.AccountNotFoundException;
import com.dvimer.payments.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("list")
    public List<Account> listAgents() {
        List<Account> all = accountService.findAll();
        if (all.isEmpty()) throw new AccountNotFoundException();
        return all;
    }

    @GetMapping
    public Account info(@RequestParam(value = "number") Long number) {
        return accountService.findByNumber(number).orElseThrow(AccountNotFoundException::new);
    }

    @PostMapping
    public void save(@Valid @RequestBody Account account) {
        accountService.save(account);
    }

    @PutMapping("/add")
    public void putMoney(@Valid @RequestBody AccountInfo accountInfo) {
        accountService.deposit(accountInfo);
    }

    @PutMapping("/withdraw")
    public void withdrawMoney(@Valid @RequestBody AccountInfo accountInfo) {
        accountService.withdraw(accountInfo);
    }

    @PostMapping("/transaction")
    public void transactionMoney(@Valid @RequestBody TransactionMoney transactionMoney) {
        Account from = accountService.findByNumber(transactionMoney.getFrom()).orElseThrow(AccountNotFoundException::new);
        Account to = accountService.findByNumber(transactionMoney.getTo()).orElseThrow(AccountNotFoundException::new);
        accountService.transferMoney(from, to, transactionMoney.getAmount());
    }
}
