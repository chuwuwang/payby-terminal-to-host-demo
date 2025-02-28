package com.payby.terminal.demo.http.response.device;

import com.payby.terminal.demo.http.entity.FeatureState;
import com.payby.terminal.demo.http.entity.Money;

import java.util.Map;

public class Device {
    private String name;
    private String type;
    private String deviceId;
    private String status;
    private String storeId;
    private String merchantMid;
    private String tipsType;
    private float tipsMaxRate;
    private Money tipsMaxAmount;
    private String tipsChannelCode;
    private Map<String, String> extParams;
    private Map<String, FeatureState> extParamsModel;

    public Device () {
        this.name = "";
        this.type = "";
        this.deviceId = "";
        this.status = "";
        this.storeId = "";
        this.merchantMid = "";
        this.tipsType = "";
        this.tipsMaxRate = 0;
        this.tipsMaxAmount = new Money();
        this.tipsChannelCode = "";
        this.extParams = null;
        this.extParamsModel = null;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getDeviceId() {
        return deviceId;
    }
    public String getStatus() {
        return status;
    }
    public String getStoreId() {
        return storeId;
    }
    public String getMerchantMid() {
        return merchantMid;
    }
    public String getTipsType() {
        return tipsType;
    }
    public float getTipsMaxRate() {
        return tipsMaxRate;
    }
    public Money getTipsMaxAmount() {
        return tipsMaxAmount;
    }
    public String getTipsChannelCode() {
        return tipsChannelCode;
    }
    public Map<String, String> getExtParams() {
        return extParams;
    }
    public Map<String, FeatureState> getExtParamsModel() {
        return extParamsModel;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", status='" + status + '\'' +
                ", storeId='" + storeId + '\'' +
                ", merchantMid='" + merchantMid + '\'' +
                ", tipsType='" + tipsType + '\'' +
                ", tipsMaxRate=" + tipsMaxRate +
                ", tipsMaxAmount=" + tipsMaxAmount +
                ", tipsChannelCode='" + tipsChannelCode + '\'' +
                ", extParams=" + extParams +
                ", extParamsModel=" + extParamsModel +
                '}';
    }
}
