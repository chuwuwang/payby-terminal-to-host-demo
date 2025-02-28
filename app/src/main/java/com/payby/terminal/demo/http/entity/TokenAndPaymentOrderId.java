package com.payby.terminal.demo.http.entity;

public class TokenAndPaymentOrderId {
    private String token;
    private String paymentOrderId;

    public TokenAndPaymentOrderId() {
        this.token = "";
        this.paymentOrderId = "";
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setPaymentOrderId(String paymentOrderId) {
        this.paymentOrderId = paymentOrderId;
    }

    public String getToken() {
        return token;
    }

    public String getPaymentOrderId() {
        return paymentOrderId;
    }

    @Override
    public String toString() {
        return "TokenAndPaymentOrderId{" +
                "token='" + token + '\'' +
                ", paymentOrderId='" + paymentOrderId + '\'' +
                '}';
    }
}
