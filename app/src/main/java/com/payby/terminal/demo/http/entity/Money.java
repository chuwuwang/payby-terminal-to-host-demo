package com.payby.terminal.demo.http.entity;

import java.math.BigDecimal;

public class Money {
    private BigDecimal amount;
    private String currency;
    public Money() {
        this.amount = new BigDecimal("0.00");
        this.currency = "AED";
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public String getCurrency() {
        return currency;
    }
    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
