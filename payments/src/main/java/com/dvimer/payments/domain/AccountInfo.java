package com.dvimer.payments.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class AccountInfo {
    @NotNull(message = "The amount must be")
    @Min(message = "The amount must be greater than 0", value = 0)
    private BigDecimal amount;
    @NotNull(message = "The number must be")
    private Long number;

    public AccountInfo() {
    }

    public AccountInfo(BigDecimal amount, Long number) {
        this.amount = amount;
        this.number = number;
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
        AccountInfo that = (AccountInfo) o;
        return Objects.equals(amount, that.amount) &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, number);
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "amount=" + amount +
                ", number=" + number +
                '}';
    }
}
