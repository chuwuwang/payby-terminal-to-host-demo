package com.payby.terminal.demo.http.entity;

import java.util.Map;

public class PaymentOrder {
    private String id;
    private String status;
    private String paidTime;
    private String payMethod;
    private Map<String, String> extensions;

    public PaymentOrder() {
        this.id = "";
        this.status = "";
        this.paidTime = "";
        this.payMethod = "";
        this.extensions = null;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setPaidTime(String paidTime) {
        this.paidTime = paidTime;
    }
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }
    public void setExtensions(Map<String, String> extensions) {
        this.extensions = extensions;
    }

    public String getId() {
        return id;
    }
    public String getStatus() {
        return status;
    }
    public String getPaidTime() {
        return paidTime;
    }
    public String getPayMethod() {
        return payMethod;
    }
    public Map<String, String> getExtensions() {
        return extensions;
    }

    @Override
    public String toString() {
        return "PaymentOrder{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", paidTime='" + paidTime + '\'' +
                ", payMethod='" + payMethod + '\'' +
                ", extensions=" + extensions +
                '}';
    }
}
