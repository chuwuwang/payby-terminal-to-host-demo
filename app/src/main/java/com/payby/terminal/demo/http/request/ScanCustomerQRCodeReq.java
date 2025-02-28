package com.payby.terminal.demo.http.request;

public class ScanCustomerQRCodeReq {
    private String token;
    private String qrCode;
    private String deviceLongitude;
    private String deviceLatitude;

    public ScanCustomerQRCodeReq() {
        this.token = "";
        this.qrCode = "";
        this.deviceLongitude = "";
        this.deviceLatitude = "";
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
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

    public String getQrCode() {
        return qrCode;
    }

    public String getDeviceLongitude() {
        return deviceLongitude;
    }

    public String getDeviceLatitude() {
        return deviceLatitude;
    }

    @Override
    public String toString() {
        return "ScanCustomerQRCodeReq{" +
                "token='" + token + '\'' +
                ", qrCode='" + qrCode + '\'' +
                ", deviceLongitude='" + deviceLongitude + '\'' +
                ", deviceLatitude='" + deviceLatitude + '\'' +
                '}';
    }
}
