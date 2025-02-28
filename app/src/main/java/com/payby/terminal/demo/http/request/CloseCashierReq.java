package com.payby.terminal.demo.http.request;

public class CloseCashierReq {
    private String token;

    public CloseCashierReq() {
        this.token = "";
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "CloseCashierReq{" +
                "token='" + token + '\'' +
                '}';
    }
}
