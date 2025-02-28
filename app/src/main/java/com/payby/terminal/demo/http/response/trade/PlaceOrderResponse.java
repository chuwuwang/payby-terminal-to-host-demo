package com.payby.terminal.demo.http.response.trade;

import com.payby.terminal.demo.http.entity.trade.AcquireOrder;

public class PlaceOrderResponse {
    private String token;
    private AcquireOrder acquireOrder;
    private String cashierDeskUrl;

    public PlaceOrderResponse() {
        this.token = "";
        this.acquireOrder = new AcquireOrder();
        this.cashierDeskUrl = "";
    }

    public void setToken(String token) {
        this.token = token;
    }
    public void setAcquireOrder(AcquireOrder acquireOrder) {
        this.acquireOrder = acquireOrder;
    }
    public void setCashierDeskUrl(String cashierDeskUrl) {
        this.cashierDeskUrl = cashierDeskUrl;
    }

    public String getToken() {
        return token;
    }
    public AcquireOrder getAcquireOrder() {
        return acquireOrder;
    }
    public String getCashierDeskUrl() {
        return cashierDeskUrl;
    }

    @Override
    public String toString() {
        return "PlaceOrderResponse{" +
                "token='" + token + '\'' +
                ", acquireOrder=" + acquireOrder +
                ", cashierDeskUrl='" + cashierDeskUrl + '\'' +
                '}';
    }
}
