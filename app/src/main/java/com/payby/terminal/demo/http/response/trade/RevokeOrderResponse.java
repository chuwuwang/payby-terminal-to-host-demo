package com.payby.terminal.demo.http.response.trade;

public class RevokeOrderResponse {
    private String revokedAcquireOrderId;

    public RevokeOrderResponse() {
        this.revokedAcquireOrderId = "";
    }

    public void setRevokedAcquireOrderId(String revokedAcquireOrderId) {
        this.revokedAcquireOrderId = revokedAcquireOrderId;
    }

    public String getRevokedAcquireOrderId() {
        return revokedAcquireOrderId;
    }

    @Override
    public String toString() {
        return "RevokeOrderResponse{" +
                "revokedAcquireOrderId='" + revokedAcquireOrderId + '\'' +
                '}';
    }
}
