package com.payby.terminal.demo.http.request;

import com.payby.terminal.demo.http.entity.trade.OrderIndex;

public class RevokeOrderReq {
    private String acquireOrderScope;
    private OrderIndex acquireOrderId;

    public RevokeOrderReq() {
        this.acquireOrderScope = "STORE";
        this.acquireOrderId = new OrderIndex();
    }

    public void setAcquireOrderScope(String acquireOrderScope) {
        this.acquireOrderScope = acquireOrderScope;
    }

    public void setAcquireOrderId(OrderIndex acquireOrderId) {
        this.acquireOrderId = acquireOrderId;
    }

    public String getAcquireOrderScope() {
        return acquireOrderScope;
    }

    public OrderIndex getAcquireOrderId() {
        return acquireOrderId;
    }

    @Override
    public String toString() {
        return "RevokeOrderReq{" +
                "acquireOrderScope='" + acquireOrderScope + '\'' +
                ", acquireOrderId=" + acquireOrderId +
                '}';
    }
}
