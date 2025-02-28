package com.payby.terminal.demo.http.entity.trade;

import com.payby.terminal.demo.http.entity.Money;

public class AmountDetail {
    private Money amount;
    private Money vatAmount;
    private Money tipAmount;
    private Money discountableAmount;

    public AmountDetail() {
        this.amount = new Money();
        this.vatAmount = new Money();
        this.tipAmount = new Money();
        this.discountableAmount = new Money();
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }
    public void setVatAmount(Money vatAmount) {
        this.vatAmount = vatAmount;
    }
    public void setTipAmount(Money tipAmount) {
        this.tipAmount = tipAmount;
    }
    public void setDiscountableAmount(Money discountableAmount) {
        this.discountableAmount = discountableAmount;
    }

    public Money getAmount() {
        return amount;
    }
    public Money getVatAmount() {
        return vatAmount;
    }
    public Money getTipAmount() {
        return tipAmount;
    }
    public Money getDiscountableAmount() {
        return discountableAmount;
    }

    @Override
    public String toString() {
        return "AmountDetail{" +
                "amount=" + amount +
                ", vatAmount=" + vatAmount +
                ", tipAmount=" + tipAmount +
                ", discountableAmount=" + discountableAmount +
                '}';
    }
}
