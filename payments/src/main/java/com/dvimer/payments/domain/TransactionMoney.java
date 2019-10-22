package com.dvimer.payments.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class TransactionMoney {
    @NotNull(message = "Be sure to indicate the account from which to write off")
    private Long from;
    @NotNull(message = "Be sure to indicate the account where to credit")
    private Long to;
    @Min(value = 0, message = "Min amount need more 0")
    @NotNull(message = "amount need set")
    private BigDecimal amount;

    public TransactionMoney() {
    }

    public TransactionMoney(Long from, Long to, BigDecimal amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionAccount{" +
                "from=" + from +
                ", to=" + to +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionMoney that = (TransactionMoney) o;
        return Objects.equals(from, that.from) &&
                Objects.equals(to, that.to) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, amount);
    }
}
