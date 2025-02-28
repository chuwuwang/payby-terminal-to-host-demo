package com.payby.terminal.demo.http.request;

public class ActiveReq {
    private String code;
    private String pubKey;
    private String posDeviceType;

    public ActiveReq() {
        this.code = "";
        this.pubKey = "";
        this.posDeviceType = "";
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getPubKey() {
        return pubKey;
    }
    public void setPubKey(String pubKey) {
        this.pubKey = pubKey;
    }
    public String getPosDeviceType() {
        return posDeviceType;
    }
    public void setPosDeviceType(String posDeviceType) {
        this.posDeviceType = posDeviceType;
    }
    @Override
    public String toString() {
        return "ActiveReq{" +
                "code='" + code + '\'' +
                ", pubKey='" + pubKey + '\'' +
                ", posDeviceType='" + posDeviceType + '\'' +
                '}';
    }
}
