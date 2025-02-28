package com.payby.terminal.demo.http.entity.trade;

public class SecondaryMerchantDetail {
    private String id;
    private String mcc;
    private String name;
    private Long innerId;

    public SecondaryMerchantDetail() {
        this.id = "";
        this.mcc = "";
        this.name = "";
        this.innerId = 0L;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setMcc(String mcc) {
        this.mcc = mcc;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setInnerId(Long innerId) {
        this.innerId = innerId;
    }

    public String getId() {
        return id;
    }
    public String getMcc() {
        return mcc;
    }
    public String getName() {
        return name;
    }
    public Long getInnerId() {
        return innerId;
    }

    @Override
    public String toString() {
        return "SecondaryMerchantDetail{" +
                "id='" + id + '\'' +
                ", mcc='" + mcc + '\'' +
                ", name='" + name + '\'' +
                ", innerId=" + innerId +
                '}';
    }
}
