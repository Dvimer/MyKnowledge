package com.dvimer.payments.controller;

import com.dvimer.payments.domain.AccountInfo;
import com.dvimer.payments.domain.TransactionMoney;
import com.dvimer.payments.entity.Account;
import com.dvimer.payments.exception.AccountLessMoneyException;
import com.dvimer.payments.exception.AccountNotFoundException;
import com.dvimer.payments.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping("/put")
    public void putMoney(@Valid @RequestBody AccountInfo accountInfo) {
        Account currentAccount = accountService.findByNumber(accountInfo.getNumber()).orElseThrow(AccountNotFoundException::new);
        currentAccount.setAmount(currentAccount.getAmount().add(accountInfo.getAmount()));
        accountService.save(currentAccount);
    }

    @PutMapping("/withdraw")
    public void withdrawMoney(@Valid @RequestBody AccountInfo accountInfo) {
        Account currentAccount = accountService.findByNumber(accountInfo.getNumber()).orElseThrow(AccountNotFoundException::new);
        substructAmount(currentAccount, accountInfo.getAmount());
        accountService.save(currentAccount);
    }

    @PostMapping("/transaction")
    public void transactionMoney(@Valid @RequestBody TransactionMoney transactionMoney) {
        Account from = accountService.findByNumber(transactionMoney.getFrom()).orElseThrow(AccountNotFoundException::new);
        Account to = accountService.findByNumber(transactionMoney.getTo()).orElseThrow(AccountNotFoundException::new);

        substructAmount(from, transactionMoney.getAmount());
        to.setAmount(to.getAmount().add(transactionMoney.getAmount()));
        HashSet<Account> set = new HashSet<>();
        set.add(from);
        set.add(to);
        accountService.saveAll(set);
    }

    private void substructAmount(Account currentAccount, BigDecimal amount) {
        BigDecimal subtract = currentAccount.getAmount().subtract(amount);
        if (subtract.compareTo(BigDecimal.ZERO) < 0) {
            throw new AccountLessMoneyException();
        }
        currentAccount.setAmount(subtract);
    }
}
