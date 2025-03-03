package com.payby.terminal.demo.repository;

import com.google.gson.reflect.TypeToken;
import com.payby.terminal.demo.http.BaseResponse;
import com.payby.terminal.demo.http.CallProvider;
import com.payby.terminal.demo.http.Result;
import com.payby.terminal.demo.http.entity.PaymentOrder;
import com.payby.terminal.demo.http.entity.trade.PaymentInteraction;
import com.payby.terminal.demo.http.request.ActiveReq;
import com.payby.terminal.demo.http.request.CardAuthorizationReq;
import com.payby.terminal.demo.http.request.CardPaymentReq;
import com.payby.terminal.demo.http.request.CloseCashierReq;
import com.payby.terminal.demo.http.request.InquiryCashierReq;
import com.payby.terminal.demo.http.request.InquiryPaymentOrderReq;
import com.payby.terminal.demo.http.request.PlaceOrderReq;
import com.payby.terminal.demo.http.request.RevokeOrderReq;
import com.payby.terminal.demo.http.request.ScanCustomerQRCodeReq;
import com.payby.terminal.demo.http.response.device.ConfigInfo;
import com.payby.terminal.demo.http.response.trade.CashierOrder;
import com.payby.terminal.demo.http.response.trade.PlaceOrderResponse;
import com.payby.terminal.demo.http.response.trade.RevokeOrderResponse;

import java.lang.reflect.Type;

import retrofit2.Call;

public class TradeRepository extends BaseRepository {
    private static  final  TradeRepository instance = new TradeRepository();
    private TradeRepository() {
    }

    public static TradeRepository getInstance() {
        return instance;
    }

    public static Result<String> activeTerminal(ActiveReq req) {
        Type type = new TypeToken<BaseResponse<String>>() {}.getType();
        return safeCall(type, () -> deviceService(req, "active"));
    }

    public static Result<ConfigInfo> getDeviceInfo() {
        Type type = new TypeToken<BaseResponse<ConfigInfo>>() {}.getType();
        return safeCall(type, () ->gatewayService("", "getDeviceInfo"));
    }
    public static Result<PlaceOrderResponse> placeOrder(PlaceOrderReq req) {
        Type type = new TypeToken<BaseResponse<PlaceOrderResponse>>() {}.getType();
        return safeCall(type, () ->gatewayService(req, "/acquire/place"));
    }

    public static Result<PaymentOrder> cardPayment(CardPaymentReq req) {
        Type type = new TypeToken<BaseResponse<PaymentOrder>>() {}.getType();
        return safeCall(type, () ->gatewayService(req, "/cashier/bankcard/place"));
    }

    public static Result<PaymentOrder> card2ndAuth(CardAuthorizationReq req) {
        Type type = new TypeToken<BaseResponse<PaymentOrder>>() {}.getType();
        return safeCall(type, () ->gatewayService(req, "/cashier/bankcard/auth2"));
    }

    public static Result<CashierOrder> inquiryCashier(InquiryCashierReq req) {
        Type type = new TypeToken<BaseResponse<CashierOrder>>() {}.getType();
        return safeCall(type, () ->gatewayService(req, "/cashier/get"));
    }

    public static Result<Object> closeCashier(CloseCashierReq req) {
        Type type = new TypeToken<BaseResponse<Object>>() {}.getType();
        return safeCall(type, () ->gatewayService(req, "/cashier/close"));
    }

    public static Result<RevokeOrderResponse> revokeOrder(RevokeOrderReq req) {
        Type type = new TypeToken<BaseResponse<RevokeOrderResponse>>() {}.getType();
        return safeCall(type, () ->gatewayService(req, "/acquire/revoke/place"));
    }

    public static Result<String> showMerchantQRCode(String token) {
        Type type = new TypeToken<BaseResponse<String>>() {}.getType();
        return safeCall(type, () ->gatewayService(token, "/cashier/qrCode/merchant/get"));
    }

    public static Result<PaymentInteraction> scanCustomerQRCode(ScanCustomerQRCodeReq req) {
        Type type = new TypeToken<BaseResponse<PaymentInteraction>>() {}.getType();
        return safeCall(type, () ->gatewayService(req, "/cashier/qrCode/customer/create"));
    }

    public static Result<PaymentOrder> inquiryPaymentOrder(InquiryPaymentOrderReq req) {
        Type type = new TypeToken<BaseResponse<PaymentOrder>>() {}.getType();
        return safeCall(type, () ->gatewayService(req, "/cashier/getPaymentOrder"));
    }
}
