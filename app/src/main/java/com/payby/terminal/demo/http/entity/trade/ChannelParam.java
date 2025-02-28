package com.payby.terminal.demo.http.entity.trade;

public class ChannelParam {
    private String traceNo;
    private String cardTransactionNo;
    private String cardAuthorizationNo;
    private String iso8583ResponseCode;

    public ChannelParam() {
        this.traceNo = "";
        this.cardTransactionNo = "";
        this.cardAuthorizationNo = "";
        this.iso8583ResponseCode = "";
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }
    public void setCardTransactionNo(String cardTransactionNo) {
        this.cardTransactionNo = cardTransactionNo;
    }
    public void setCardAuthorizationNo(String cardAuthorizationNo) {
        this.cardAuthorizationNo = cardAuthorizationNo;
    }
    public void setIso8583ResponseCode(String iso8583ResponseCode) {
        this.iso8583ResponseCode = iso8583ResponseCode;
    }

    public String getTraceNo() {
        return traceNo;
    }
    public String getCardTransactionNo() {
        return cardTransactionNo;
    }
    public String getCardAuthorizationNo() {
        return cardAuthorizationNo;
    }
    public String getIso8583ResponseCode() {
        return iso8583ResponseCode;
    }

    @Override
    public String toString() {
        return "ChannelParam{" +
                "traceNo='" + traceNo + '\'' +
                ", cardTransactionNo='" + cardTransactionNo + '\'' +
                ", cardAuthorizationNo='" + cardAuthorizationNo + '\'' +
                ", iso8583ResponseCode='" + iso8583ResponseCode + '\'' +
                '}';
    }
}
