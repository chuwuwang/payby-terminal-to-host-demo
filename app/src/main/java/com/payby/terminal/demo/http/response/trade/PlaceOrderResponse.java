package com.payby.terminal.demo.http.response.trade;

import com.payby.terminal.demo.http.entity.trade.AcquireOrder;

public class PlaceOrderResponse {
    private String token;
    private AcquireOrder order;
    private String cashierDeskUrl;

    public PlaceOrderResponse() {
        this.token = "";
        this.order = new AcquireOrder();
        this.cashierDeskUrl = "";
    }

    public void setToken(String token) {
        this.token = token;
    }
    public void setAcquireOrder(AcquireOrder acquireOrder) {
        this.order = acquireOrder;
    }
    public void setCashierDeskUrl(String cashierDeskUrl) {
        this.cashierDeskUrl = cashierDeskUrl;
    }

    public String getToken() {
        return token;
    }
    public AcquireOrder getAcquireOrder() {
        return order;
    }
    public String getCashierDeskUrl() {
        return cashierDeskUrl;
    }

    @Override
    public String toString() {
        return "PlaceOrderResponse{" +
                "token='" + token + '\'' +
                ", acquireOrder=" + order +
                ", cashierDeskUrl='" + cashierDeskUrl + '\'' +
                '}';
    }
}
