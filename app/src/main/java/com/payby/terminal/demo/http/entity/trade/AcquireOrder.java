package com.payby.terminal.demo.http.entity.trade;

import com.payby.terminal.demo.http.entity.Money;

public class AcquireOrder {
    private String status;
    private String orderNo;
    private Money totalAmount;
    private String misOrderNo;
    private String merchantOrderNo;

    private String failDes;
    private String failCode;
    private String failMessage;

    private Issuer issuer;
    private String subject;
    private String reserved;
    private String requestTime;
    private String createdTime;
    private String expiredTime;
    private String payeeMid;
    private String partnerId;
    private String merchantId;
    private String productCode;
    private PaymentInfo paymentInfo;
    private AccessoryContent accessoryContent;
    private Boolean revoked;
    private Boolean reversal;

    public AcquireOrder() {
        this.status = "";
        this.orderNo = "";
        this.totalAmount = new Money();
        this.misOrderNo = "";
        this.merchantOrderNo = "";
        this.failDes = "";
        this.failCode = "";
        this.failMessage = "";
        this.issuer = new Issuer();
        this.subject = "";
        this.reserved = "";
        this.requestTime = "";
        this.createdTime = "";
        this.expiredTime = "";
        this.payeeMid = "";
        this.partnerId = "";
        this.merchantId = "";
        this.productCode = "";
        this.paymentInfo = new PaymentInfo();
        this.accessoryContent = new AccessoryContent();
        this.revoked = false;
        this.reversal = false;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public void setTotalAmount(Money totalAmount) {
        this.totalAmount = totalAmount;
    }
    public void setMisOrderNo(String misOrderNo) {
        this.misOrderNo = misOrderNo;
    }
    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }
    public void setFailDes(String failDes) {
        this.failDes = failDes;
    }
    public void setFailCode(String failCode) {
        this.failCode = failCode;
    }
    public void setFailMessage(String failMessage) {
        this.failMessage = failMessage;
    }
    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setReserved(String reserved) {
        this.reserved = reserved;
    }
    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
    public void setExpiredTime(String expiredTime) {
        this.expiredTime = expiredTime;
    }
    public void setPayeeMid(String payeeMid) {
        this.payeeMid = payeeMid;
    }
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }
    public void setAccessoryContent(AccessoryContent accessoryContent) {
        this.accessoryContent = accessoryContent;
    }
    public void setRevoked(Boolean revoked) {
        this.revoked = revoked;
    }
    public void setReversal(Boolean reversal) {
        this.reversal = reversal;
    }

    public String getStatus() {
        return status;
    }
    public String getOrderNo() {
        return orderNo;
    }
    public Money getTotalAmount() {
        return totalAmount;
    }
    public String getMisOrderNo() {
        return misOrderNo;
    }
    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }
    public String getFailDes() {
        return failDes;
    }
    public String getFailCode() {
        return failCode;
    }
    public String getFailMessage() {
        return failMessage;
    }
    public Issuer getIssuer() {
        return issuer;
    }
    public String getSubject() {
        return subject;
    }
    public String getReserved() {
        return reserved;
    }
    public String getRequestTime() {
        return requestTime;
    }
    public String getCreatedTime() {
        return createdTime;
    }
    public String getExpiredTime() {
        return expiredTime;
    }
    public String getPayeeMid() {
        return payeeMid;
    }
    public String getPartnerId() {
        return partnerId;
    }
    public String getMerchantId() {
        return merchantId;
    }
    public String getProductCode() {
        return productCode;
    }
    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }
    public AccessoryContent getAccessoryContent() {
        return accessoryContent;
    }
    public Boolean getRevoked() {
        return revoked;
    }
    public Boolean getReversal() {
        return reversal;
    }

    @Override
    public String toString() {
        return "AcquireOrder{" +
                "status='" + status + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", totalAmount=" + totalAmount +
                ", misOrderNo='" + misOrderNo + '\'' +
                ", merchantOrderNo='" + merchantOrderNo + '\'' +
                ", failDes='" + failDes + '\'' +
                ", failCode='" + failCode + '\'' +
                ", failMessage='" + failMessage + '\'' +
                ", issuer=" + issuer +
                ", subject='" + subject + '\'' +
                ", reserved='" + reserved + '\'' +
                ", requestTime='" + requestTime + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", expiredTime='" + expiredTime + '\'' +
                ", payeeMid='" + payeeMid + '\'' +
                ", partnerId='" + partnerId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", productCode='" + productCode + '\'' +
                ", paymentInfo=" + paymentInfo +
                ", accessoryContent=" + accessoryContent +
                ", revoked=" + revoked +
                ", reversal=" + reversal +
                '}';
    }
}
