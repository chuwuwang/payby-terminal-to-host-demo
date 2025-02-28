package com.payby.terminal.demo.http.request;

public class InquiryPaymentOrderReq {
    private String token;
    private String paymentOrderId;
    private String paymentRequestNo;

    public InquiryPaymentOrderReq() {
        this.token = "";
        this.paymentOrderId = "";
        this.paymentRequestNo = "";
    }
    public void setToken(String token) {
        this.token = token;
    }
    public void setPaymentOrderId(String paymentOrderId) {
        this.paymentOrderId = paymentOrderId;
    }
    public void setPaymentRequestNo(String paymentRequestNo) {
        this.paymentRequestNo = paymentRequestNo;
    }
    public String getToken() {
        return token;
    }
    public String getPaymentOrderId() {
        return paymentOrderId;
    }
    public String getPaymentRequestNo() {
        return paymentRequestNo;
    }

    @Override
    public String toString() {
        return "InquiryPaymentOrderReq{" +
                "token='" + token + '\'' +
                ", paymentOrderId='" + paymentOrderId + '\'' +
                ", paymentRequestNo='" + paymentRequestNo + '\'' +
                '}';
    }
}
