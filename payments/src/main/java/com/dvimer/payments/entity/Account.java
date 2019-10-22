package com.dvimer.payments.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private int id;
    @Min(0)
    private BigDecimal amount;
    @Column(unique = true)
    private Long number;

    public Account() {
    }

    public Account(BigDecimal amount, Long number) {
        this.amount = amount;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                Objects.equals(amount, account.amount) &&
                Objects.equals(number, account.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, number);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", amount=" + amount +
                ", number=" + number +
                '}';
    }
}
