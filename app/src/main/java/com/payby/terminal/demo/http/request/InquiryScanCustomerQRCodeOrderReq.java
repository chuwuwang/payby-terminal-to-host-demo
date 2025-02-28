package com.payby.terminal.demo.http.request;

public class InquiryScanCustomerQRCodeOrderReq {
    private String token;
    private String cpcPayToken;

    public InquiryScanCustomerQRCodeOrderReq() {
        this.token = "";
        this.cpcPayToken = "";
    }

    public void setToken(String token) {
        this.token = token;
    }
    public void setCpcPayToken(String cpcPayToken) {
        this.cpcPayToken = cpcPayToken;
    }
    public String getToken() {
        return token;
    }
    public String getCpcPayToken() {
        return cpcPayToken;
    }

    @Override
    public String toString() {
        return "InquiryScanCustomerQRCodeOrderReq{" +
                "token='" + token + '\'' +
                ", cpcPayToken='" + cpcPayToken + '\'' +
                '}';
    }
}
