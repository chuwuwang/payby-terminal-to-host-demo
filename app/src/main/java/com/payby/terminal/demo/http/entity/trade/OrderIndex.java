package com.payby.terminal.demo.http.entity.trade;

public class OrderIndex {
    private String orderNo;
    private String merchantOrderNo;

    public OrderIndex() {
        this.orderNo = "";
        this.merchantOrderNo = "";
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    @Override
    public String toString() {
        return "OrderIndex{" +
                "orderNo='" + orderNo + '\'' +
                ", merchantOrderNo='" + merchantOrderNo + '\'' +
                '}';
    }
}
