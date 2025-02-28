package com.payby.terminal.demo.http.response.trade;

import com.payby.terminal.demo.http.entity.Money;
import com.payby.terminal.demo.http.entity.PaymentOrder;

public class CashierOrder {
    private PaymentOrder binderPaymentOrder;
    private PaymentOrder lastFailurePaymentOrder;
    private String token;
    private String status;
    private Money orderAmount;
    private String createdTime;
    private String expiredTime;
    private String deviceId;
    private String receiptNo;
    private String failMessage;
    private String merchantName;
    private String payeeMemberId;
    private String tradeRequestNo;
    private String merchantOrderNo;
    private String merchantBusinessAddress;

    public CashierOrder() {
        this.binderPaymentOrder = null;
        this.lastFailurePaymentOrder = null;
        this.token = "";
        this.status = "";
        this.orderAmount = null;
        this.createdTime = "";
        this.expiredTime = "";
        this.deviceId = "";
        this.receiptNo = "";
        this.failMessage = "";
        this.merchantName = "";
        this.payeeMemberId = "";
        this.tradeRequestNo = "";
        this.merchantOrderNo = "";
        this.merchantBusinessAddress = "";
    }

    public void setBinderPaymentOrder(PaymentOrder binderPaymentOrder) {
        this.binderPaymentOrder = binderPaymentOrder;
    }
    public void setLastFailurePaymentOrder(PaymentOrder lastFailurePaymentOrder) {
        this.lastFailurePaymentOrder = lastFailurePaymentOrder;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setOrderAmount(Money orderAmount) {
        this.orderAmount = orderAmount;
    }
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
    public void setExpiredTime(String expiredTime) {
        this.expiredTime = expiredTime;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }
    public void setFailMessage(String failMessage) {
        this.failMessage = failMessage;
    }
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
    public void setPayeeMemberId(String payeeMemberId) {
        this.payeeMemberId = payeeMemberId;
    }
    public void setTradeRequestNo(String tradeRequestNo) {
        this.tradeRequestNo = tradeRequestNo;
    }
    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }
    public void setMerchantBusinessAddress(String merchantBusinessAddress) {
        this.merchantBusinessAddress = merchantBusinessAddress;
    }

    public PaymentOrder getBinderPaymentOrder() {
        return binderPaymentOrder;
    }
    public PaymentOrder getLastFailurePaymentOrder() {
        return lastFailurePaymentOrder;
    }
    public String getToken() {
        return token;
    }
    public String getStatus() {
        return status;
    }
    public Money getOrderAmount() {
        return orderAmount;
    }
    public String getCreatedTime() {
        return createdTime;
    }
    public String getExpiredTime() {
        return expiredTime;
    }
    public String getDeviceId() {
        return deviceId;
    }
    public String getReceiptNo() {
        return receiptNo;
    }
    public String getFailMessage() {
        return failMessage;
    }
    public String getMerchantName() {
        return merchantName;
    }
    public String getPayeeMemberId() {
        return payeeMemberId;
    }
    public String getTradeRequestNo() {
        return tradeRequestNo;
    }
    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }
    public String getMerchantBusinessAddress() {
        return merchantBusinessAddress;
    }

    @Override
    public String toString() {
        return "CashierOrder{" +
                "binderPaymentOrder=" + binderPaymentOrder +
                ", lastFailurePaymentOrder=" + lastFailurePaymentOrder +
                ", token='" + token + '\'' +
                ", status='" + status + '\'' +
                ", orderAmount=" + orderAmount +
                ", createdTime='" + createdTime + '\'' +
                ", expiredTime='" + expiredTime + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", receiptNo='" + receiptNo + '\'' +
                ", failMessage='" + failMessage + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", payeeMemberId='" + payeeMemberId + '\'' +
                ", tradeRequestNo='" + tradeRequestNo + '\'' +
                ", merchantOrderNo='" + merchantOrderNo + '\'' +
                ", merchantBusinessAddress='" + merchantBusinessAddress + '\'' +
                '}';
    }
}
