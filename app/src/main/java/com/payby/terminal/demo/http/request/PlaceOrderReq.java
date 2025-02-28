package com.payby.terminal.demo.http.request;

import com.payby.terminal.demo.http.entity.Money;
import com.payby.terminal.demo.http.entity.trade.AccessoryContent;

public class PlaceOrderReq {
    private String subject;
    private String merchantOrderNo;
    private Money totalAmount;
    private String reserved;
    private String payeeMid;
    private String expiredTime;
    private AccessoryContent accessoryContent;
    private String operatorId;

    public PlaceOrderReq() {
        this.subject = "";
        this.merchantOrderNo = "";
        this.totalAmount = null;
        this.reserved = "";
        this.payeeMid = "";
        this.expiredTime = "";
        this.accessoryContent = null;
        this.operatorId = "";
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }
    public void setTotalAmount(Money totalAmount) {
        this.totalAmount = totalAmount;
    }
    public void setReserved(String reserved) {
        this.reserved = reserved;
    }
    public void setPayeeMid(String payeeMid) {
        this.payeeMid = payeeMid;
    }
    public void setExpiredTime(String expiredTime) {
        this.expiredTime = expiredTime;
    }
    public void setAccessoryContent(AccessoryContent accessoryContent) {
        this.accessoryContent = accessoryContent;
    }
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getSubject() {
        return subject;
    }
    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }
    public Money getTotalAmount() {
        return totalAmount;
    }
    public String getReserved() {
        return reserved;
    }
    public String getPayeeMid() {
        return payeeMid;
    }
    public String getExpiredTime() {
        return expiredTime;
    }
    public AccessoryContent getAccessoryContent() {
        return accessoryContent;
    }
    public String getOperatorId() {
        return operatorId;
    }

    @Override
    public String toString() {
        return "PlaceOrderReq{" +
                "subject='" + subject + '\'' +
                ", merchantOrderNo='" + merchantOrderNo + '\'' +
                ", totalAmount=" + totalAmount +
                ", reserved='" + reserved + '\'' +
                ", payeeMid='" + payeeMid + '\'' +
                ", expiredTime='" + expiredTime + '\'' +
                ", accessoryContent=" + accessoryContent +
                ", operatorId='" + operatorId + '\'' +
                '}';
    }
}
