package com.payby.terminal.demo.http.request;

public class InquiryCashierReq {
    private String token;
    private Boolean withBinderPaymentOrder;
    private Boolean withLastFailurePaymentOrder;

    public InquiryCashierReq() {
        this.token = "";
        this.withBinderPaymentOrder = true;
        this.withLastFailurePaymentOrder = true;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public void setWithBinderPaymentOrder(Boolean withBinderPaymentOrder) {
        this.withBinderPaymentOrder = withBinderPaymentOrder;
    }

    public void setWithLastFailurePaymentOrder(Boolean withLastFailurePaymentOrder) {
        this.withLastFailurePaymentOrder = withLastFailurePaymentOrder;
    }

    public String getToken() {
        return token;
    }
    public Boolean getWithBinderPaymentOrder() {
        return withBinderPaymentOrder;
    }
    public Boolean getWithLastFailurePaymentOrder() {
        return withLastFailurePaymentOrder;
    }

    @Override
    public String toString() {
        return "InquiryCashierReq{" +
                "token='" + token + '\'' +
                ", withBinderPaymentOrder=" + withBinderPaymentOrder +
                ", withLastFailurePaymentOrder=" + withLastFailurePaymentOrder +
                '}';
    }
}
