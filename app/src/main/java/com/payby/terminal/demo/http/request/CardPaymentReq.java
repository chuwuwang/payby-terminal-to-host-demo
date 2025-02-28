package com.payby.terminal.demo.http.request;

import java.util.Map;

public class CardPaymentReq {
    private String token;
    private String cardMaskNo;
    private String paymentRequestNo;
    private Map<String, Object> channelParams;
    private String deviceLongitude;
    private String deviceLatitude;

    public CardPaymentReq() {
        this.token = "";
        this.cardMaskNo = "";
        this.paymentRequestNo = "";
        this.channelParams = null;
        this.deviceLongitude = "";
        this.deviceLatitude = "";
    }

    public void setToken(String token) {
        this.token = token;
    }
    public void setCardMaskNo(String cardMaskNo) {
        this.cardMaskNo = cardMaskNo;
    }
    public void setPaymentRequestNo(String paymentRequestNo) {
        this.paymentRequestNo = paymentRequestNo;
    }
    public void setChannelParams(Map<String, Object> channelParams) {
        this.channelParams = channelParams;
    }
    public void setDeviceLongitude(String deviceLongitude) {
        this.deviceLongitude = deviceLongitude;
    }
    public void setDeviceLatitude(String deviceLatitude) {
        this.deviceLatitude = deviceLatitude;
    }

    public String getToken() {
        return token;
    }
    public String getCardMaskNo() {
        return cardMaskNo;
    }
    public String getPaymentRequestNo() {
        return paymentRequestNo;
    }
    public Map<String, Object> getChannelParams() {
        return channelParams;
    }
    public String getDeviceLongitude() {
        return deviceLongitude;
    }
    public String getDeviceLatitude() {
        return deviceLatitude;
    }

    @Override
    public String toString() {
        return "CardPaymentReq{" +
                "token='" + token + '\'' +
                ", cardMaskNo='" + cardMaskNo + '\'' +
                ", paymentRequestNo='" + paymentRequestNo + '\'' +
                ", channelParams=" + channelParams +
                ", deviceLongitude='" + deviceLongitude + '\'' +
                ", deviceLatitude='" + deviceLatitude + '\'' +
                '}';
    }
}
