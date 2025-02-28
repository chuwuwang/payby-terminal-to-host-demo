package com.payby.terminal.demo.http.entity.trade;

public class AccessoryContent {
    private GoodsDetail  goodsDetail;
    private AmountDetail amountDetail;
    private TerminalDetail terminalDetail;
    private SecondaryMerchantDetail secondaryMerchantDetail;

    public AccessoryContent() {
        this.goodsDetail = new GoodsDetail();
        this.amountDetail = new AmountDetail();
        this.terminalDetail = new TerminalDetail();
        this.secondaryMerchantDetail = new SecondaryMerchantDetail();
    }

    public void setGoodsDetail(GoodsDetail goodsDetail) {
        this.goodsDetail = goodsDetail;
    }
    public void setAmountDetail(AmountDetail amountDetail) {
        this.amountDetail = amountDetail;
    }
    public void setTerminalDetail(TerminalDetail terminalDetail) {
        this.terminalDetail = terminalDetail;
    }
    public void setSecondaryMerchantDetail(SecondaryMerchantDetail secondaryMerchantDetail) {
        this.secondaryMerchantDetail = secondaryMerchantDetail;
    }

    public GoodsDetail getGoodsDetail() {
        return goodsDetail;
    }
    public AmountDetail getAmountDetail() {
        return amountDetail;
    }
    public TerminalDetail getTerminalDetail() {
        return terminalDetail;
    }
    public SecondaryMerchantDetail getSecondaryMerchantDetail() {
        return secondaryMerchantDetail;
    }

    @Override
    public String toString() {
        return "AccessoryContent{" +
                "goodsDetail=" + goodsDetail +
                ", amountDetail=" + amountDetail +
                ", terminalDetail=" + terminalDetail +
                ", secondaryMerchantDetail=" + secondaryMerchantDetail +
                '}';
    }
}
