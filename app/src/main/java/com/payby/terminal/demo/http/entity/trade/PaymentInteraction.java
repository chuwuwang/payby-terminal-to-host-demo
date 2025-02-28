package com.payby.terminal.demo.http.entity.trade;

public class PaymentInteraction {
    private String token;
    private String status;
    private String cpcPayToken;

    public PaymentInteraction() {
        this.token = "";
        this.status = "";
        this.cpcPayToken = "";
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCpcPayToken(String cpcPayToken) {
        this.cpcPayToken = cpcPayToken;
    }

    public String getToken() {
        return token;
    }

    public String getStatus() {
        return status;
    }

    public String getCpcPayToken() {
        return cpcPayToken;
    }

    @Override
    public String toString() {
        return "PaymentInteraction{" +
                "token='" + token + '\'' +
                ", status='" + status + '\'' +
                ", cpcPayToken='" + cpcPayToken + '\'' +
                '}';
    }
}
