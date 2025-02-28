package com.payby.terminal.demo.http.entity.trade;

public class TerminalDetail {
    private String storeId;
    private String location;
    private String storeName;
    private String terminalId;
    private String operatorId;
    private String merchantName;

    public TerminalDetail() {
        this.storeId = "";
        this.location = "";
        this.storeName = "";
        this.terminalId = "";
        this.operatorId = "";
        this.merchantName = "";
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getStoreId() {
        return storeId;
    }
    public String getLocation() {
        return location;
    }
    public String getStoreName() {
        return storeName;
    }
    public String getTerminalId() {
        return terminalId;
    }
    public String getOperatorId() {
        return operatorId;
    }
    public String getMerchantName() {
        return merchantName;
    }

    @Override
    public String toString() {
        return "TerminalDetail{" +
                "storeId='" + storeId + '\'' +
                ", location='" + location + '\'' +
                ", storeName='" + storeName + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", merchantName='" + merchantName + '\'' +
                '}';
    }
}
