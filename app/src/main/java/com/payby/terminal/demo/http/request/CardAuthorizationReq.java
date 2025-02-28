package com.payby.terminal.demo.http.request;

import com.payby.terminal.demo.http.entity.TokenAndPaymentOrderId;

public class CardAuthorizationReq {
    private String auth2Result;
    private TokenAndPaymentOrderId tokenAndPaymentOrderId;

    public CardAuthorizationReq() {
        this.auth2Result = "";
        this.tokenAndPaymentOrderId = null;
    }

    public void setAuth2Result(String auth2Result) {
        this.auth2Result = auth2Result;
    }

    public void setTokenAndPaymentOrderId(TokenAndPaymentOrderId tokenAndPaymentOrderId) {
        this.tokenAndPaymentOrderId = tokenAndPaymentOrderId;
    }

    public String getAuth2Result() {
        return auth2Result;
    }

    public TokenAndPaymentOrderId getTokenAndPaymentOrderId() {
        return tokenAndPaymentOrderId;
    }

    @Override
    public String toString() {
        return "CardAuthorizationReq{" +
                "auth2Result='" + auth2Result + '\'' +
                ", tokenAndPaymentOrderId=" + tokenAndPaymentOrderId +
                '}';
    }
}
