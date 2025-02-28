package com.payby.terminal.demo.http.entity.trade;

public class CardInfo {
    private String brand;
    private String expYear;
    private String expMonth;
    private String accessType;
    private String holderName;
    private String cardNumMask;
    private String cardNumMask2;

    public CardInfo() {
        this.brand = "";
        this.expYear = "";
        this.expMonth = "";
        this.accessType = "";
        this.holderName = "";
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }
    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }
    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    public void setCardNumMask(String cardNumMask) {
        this.cardNumMask = cardNumMask;
    }
    public void setCardNumMask2(String cardNumMask2) {
        this.cardNumMask2 = cardNumMask2;
    }

    public String getBrand() {
        return brand;
    }
    public String getExpYear() {
        return expYear;
    }
    public String getExpMonth() {
        return expMonth;
    }
    public String getAccessType() {
        return accessType;
    }
    public String getHolderName() {
        return holderName;
    }
    public String getCardNumMask() {
        return cardNumMask;
    }
    public String getCardNumMask2() {
        return cardNumMask2;
    }

    @Override
    public String toString() {
        return "CardInfo{" +
                "brand='" + brand + '\'' +
                ", expYear='" + expYear + '\'' +
                ", expMonth='" + expMonth + '\'' +
                ", accessType='" + accessType + '\'' +
                ", holderName='" + holderName + '\'' +
                ", cardNumMask='" + cardNumMask + '\'' +
                ", cardNumMask2='" + cardNumMask2 + '\'' +
                '}';
    }
}
