package com.payby.terminal.demo.http;

public class ResponseHeader {
    private String responseTime;
    private String responseCode;
    private String errorMessage;
    private String traceCode;

    public ResponseHeader() {
    }

    public ResponseHeader(String responseTime, String responseCode, String errorMessage, String traceCode) {
        this.responseTime = responseTime;
        this.responseCode = responseCode;
        this.errorMessage = errorMessage;
        this.traceCode = traceCode;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getTraceCode() {
        return traceCode;
    }

    public void setTraceCode(String traceCode) {
        this.traceCode = traceCode;
    }

    @Override
    public String toString() {
        return "ResponseHeader{" +
                "responseTime='" + responseTime + '\'' +
                ", responseCode='" + responseCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", traceCode='" + traceCode + '\'' +
                '}';
    }
}
