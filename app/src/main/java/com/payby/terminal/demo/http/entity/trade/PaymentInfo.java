package com.payby.terminal.demo.http.entity.trade;

import com.payby.terminal.demo.http.entity.Money;

public class PaymentInfo {
    private String paidTime;
    private String settledTime;
    private Money paidAmount;
    private Money payeeFeeAmount;
    private Money payerFeeAmount;
    private Money settlementAmount;
    private String payerMid;
    private CardInfo cardInfo;
    private String payChannel;
    private ChannelParam channelParam;

    public PaymentInfo() {
        this.paidTime = "";
        this.settledTime = "";
        this.paidAmount = new Money();
        this.payeeFeeAmount = new Money();
        this.payerFeeAmount = new Money();
        this.settlementAmount = new Money();
        this.payerMid = "";
        this.cardInfo = new CardInfo();
        this.payChannel = "";
        this.channelParam = new ChannelParam();
    }

    public void setPaidTime(String paidTime) {
        this.paidTime = paidTime;
    }
    public void setSettledTime(String settledTime) {
        this.settledTime = settledTime;
    }
    public void setPaidAmount(Money paidAmount) {
        this.paidAmount = paidAmount;
    }
    public void setPayeeFeeAmount(Money payeeFeeAmount) {
        this.payeeFeeAmount = payeeFeeAmount;
    }
    public void setPayerFeeAmount(Money payerFeeAmount) {
        this.payerFeeAmount = payerFeeAmount;
    }
    public void setSettlementAmount(Money settlementAmount) {
        this.settlementAmount = settlementAmount;
    }
    public void setPayerMid(String payerMid) {
        this.payerMid = payerMid;
    }
    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }
    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }
    public void setChannelParam(ChannelParam channelParam) {
        this.channelParam = channelParam;
    }

    public String getPaidTime() {
        return paidTime;
    }
    public String getSettledTime() {
        return settledTime;
    }
    public Money getPaidAmount() {
        return paidAmount;
    }
    public Money getPayeeFeeAmount() {
        return payeeFeeAmount;
    }
    public Money getPayerFeeAmount() {
        return payerFeeAmount;
    }
    public Money getSettlementAmount() {
        return settlementAmount;
    }
    public String getPayerMid() {
        return payerMid;
    }
    public CardInfo getCardInfo() {
        return cardInfo;
    }
    public String getPayChannel() {
        return payChannel;
    }
    public ChannelParam getChannelParam() {
        return channelParam;
    }

    @Override
    public String toString() {
        return "PaymentInfo{" +
                "paidTime='" + paidTime + '\'' +
                ", settledTime='" + settledTime + '\'' +
                ", paidAmount=" + paidAmount +
                ", payeeFeeAmount=" + payeeFeeAmount +
                ", payerFeeAmount=" + payerFeeAmount +
                ", settlementAmount=" + settlementAmount +
                ", payerMid='" + payerMid + '\'' +
                ", cardInfo=" + cardInfo +
                ", payChannel='" + payChannel + '\'' +
                ", channelParam=" + channelParam +
                '}';
    }
}
