package com.payby.terminal.demo.http.entity;

public class Receipt {
    private String logo;
    private String merchantMid;
    private String posMerchantName;

    public Receipt() {
        this.logo = "";
        this.merchantMid = "";
        this.posMerchantName = "";
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    public void setMerchantMid(String merchantMid) {
        this.merchantMid = merchantMid;
    }
    public void setPosMerchantName(String posMerchantName) {
        this.posMerchantName = posMerchantName;
    }

    public String getLogo() {
        return logo;
    }
    public String getMerchantMid() {
        return merchantMid;
    }
    public String getPosMerchantName() {
        return posMerchantName;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "logo='" + logo + '\'' +
                ", merchantMid='" + merchantMid + '\'' +
                ", posMerchantName='" + posMerchantName + '\'' +
                '}';
    }
}
