package com.payby.terminal.demo.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.payby.terminal.demo.R;
import com.payby.terminal.demo.http.Result;
import com.payby.terminal.demo.http.entity.Money;
import com.payby.terminal.demo.http.entity.PaymentOrder;
import com.payby.terminal.demo.http.entity.TokenAndPaymentOrderId;
import com.payby.terminal.demo.http.entity.trade.OrderIndex;
import com.payby.terminal.demo.http.entity.trade.PaymentInteraction;
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
import com.payby.terminal.demo.repository.TradeRepository;
import com.payby.terminal.demo.store.TokenCache;
import com.payby.terminal.demo.utils.GsonUtils;
import com.payby.terminal.demo.utils.ThreadPoolManager;
import com.payby.terminal.demo.view.LoadingUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CommonResponseActivity extends AppCompatActivity {
    private TextView mTextResult;
    private String token;
    public static void startAction(Context context, int nType) {
        Intent intent = new Intent(context, CommonResponseActivity.class);
        intent.putExtra("extra_type", nType);
        context.startActivity(intent);
    }
    private int nType;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_response_activity);
        mTextResult = findViewById(R.id.widget_response_text);
        nType = getIntent().getIntExtra("extra_type", 0);
        doTransaction();
    }

    private void doTransaction() {
        if (nType == 0) {
            getDeviceInfo();
        } else if (nType == 1) {
            placeOrder();
        } else if (nType == 2) {
            cardPayment();
        } else if (nType == 3) {
            card2ndAuth();
        } else if (nType == 4) {
            inquiryCashier();
        } else if (nType == 5) {
            closeCashier();
        } else if (nType == 6) {
            revokeOrder();
        } else if (nType == 7) {
           showMerchantQRCode();
        } else if (nType == 8) {
           scanCustomerQRCode();
        } else if (nType == 9) {
            inquiryPaymentOrder();
        }
    }

    private void getDeviceInfo() {
        LoadingUtils.showLoading(this, "Getting device info...");
        ThreadPoolManager.executeCacheTask(() -> {
            Result<ConfigInfo> result = TradeRepository.getDeviceInfo();
            LoadingUtils.dismissLoading();
            if (result.isSuccess()) {
                runOnUiThread(() -> {
                    ConfigInfo configInfo = result.getData();
                    mTextResult.setText( GsonUtils.getGson4LogUtils().toJson(configInfo));
                });
            } else  {
                String error = result.getError().getMessage();
                runOnUiThread(() -> {
                    mTextResult.setText("Get device info failed: " + error);
                });
            }
        });
    }

    private void placeOrder() {
        LoadingUtils.showLoading(this, "Place Order...");
        ThreadPoolManager.executeCacheTask(() -> {
            String merchantOrderNo = UUID.randomUUID().toString();
            TokenCache.saveMerchantOrderNo(merchantOrderNo);
            PlaceOrderReq req = new PlaceOrderReq();
            Money totalAmount = new Money();
            totalAmount.setAmount(BigDecimal.valueOf(10.0));
            totalAmount.setCurrency("AED");
            req.setTotalAmount(totalAmount);
            req.setMerchantOrderNo(merchantOrderNo);
            req.setSubject("Purchase AED "+req.getTotalAmount().getAmount()+" at Test StoreName");
            Result<PlaceOrderResponse> result= TradeRepository.placeOrder(req);
            LoadingUtils.dismissLoading();
            if (result.isSuccess()) {
                runOnUiThread(() -> {
                    if (result.getData()!= null) {
                        token = result.getData().getToken();
                        TokenCache.saveToken(token);
                        TokenCache.saveOrderNo(result.getData().getAcquireOrder().getOrderNo());
                    }
                    mTextResult.setText(GsonUtils.getGson4LogUtils().toJson(result.getData()));
                });
            } else  {
                String error = result.getError().getMessage();
                runOnUiThread(() -> {
                    mTextResult.setText("Place order failed: " + error);
                });
            }
        });
    }

    private void cardPayment() {
        LoadingUtils.showLoading(this, "Card Payment...");
        ThreadPoolManager.executeCacheTask(() -> {
            String paymentRequestNo = UUID.randomUUID().toString();
            TokenCache.savePaymentRequestNo(paymentRequestNo);
            CardPaymentReq req = new CardPaymentReq();
            req.setToken(TokenCache.getToken());
            req.setCardMaskNo("411939******7915");
            req.setPaymentRequestNo(paymentRequestNo);
            req.setDeviceLatitude("24.495811019518776"); //get from GPS or network
            req.setDeviceLongitude("54.40854299999998");
            Map<String, Object> channelParams = new HashMap<>();
            channelParams.put("isSignature", false);
            channelParams.put("mcSingleTapPin", false);
            channelParams.put("isFallbackTransaction", false);
            channelParams.put("isMagneticTransaction", false);
            // CONTACTLESS
//            channelParams.put("readType", "CONTACTLESS");
//            channelParams.put("passwordMode", "NO_PASSWORD");
//            channelParams.put("aid", "A0000000031010");
//            channelParams.put("auth2", "false");
//            //read from card
//            channelParams.put("iccData", "4F07A0000000031010500B5669736120437265646974820200208407A0000000031010950500000000009A032502289C01005F2A0207845F3401019F02060000000010009F03060000000000009F0607A00000000310109F090200309F100706011203A000009F120B56697361204372656469749F1A0207849F1E0837303030303030349F26081396243A4986E2569F2701809F3303E0F8C89F3501229F360200219F37042544B11E9F660436B0C0809F6C0206009F6E0440700700");
//            channelParams.put("dssKSN","10033A10C58049C000B1");
//            channelParams.put("encryptedDssData","mCP+FwTqBBKYllfqfdsjcUN7gM9+S0opcOxxqt94GcSKS+dPVSCT8f61e0ANhMy6XYXVp3ELL6QQGE21PhhG23YhhkV6kO9muxvFVb/e8xvF++400GUnpAuTLM/UKL757DuRQxtn3gvrq/ceTKNLDwGcux05p9RjPu6OqIG+CTg=");


            //CONTACT
            channelParams.put("readType", "CONTACT");
            channelParams.put("passwordMode", "ONLINE_PASSWORD");
            channelParams.put("aid", "A0000000031010");
            channelParams.put("auth2", "true");
            //read from card
            channelParams.put("iccData", "4F07A0000000031010500B5669736120437265646974820239008407A0000000031010950500000480009A032502289C01005F2A0207845F3401019F02060000000001209F03060000000000009F0607A00000000310109F090200309F100706011203A0B8029F120B56697361204372656469749F1A0207849F1E0837303030303030349F260889751D48AC978D749F2701809F3303E0F8C89F3501229F360200229F37045B56B2089F660436F0C080");
            channelParams.put("dssKSN","10033A10C58049C000B2");
            channelParams.put("encryptedDssData","PyJ1KLO5fTjJt2gn55xD698fT8N9HqUWE6vNa5t/ZdRFqVyd3ZS4B3PQM2SkpDK3PkOxfGQIZoHemWLPRAGx6G47Go22+XBehaO4VK/P/SOveY9f2lvVe+A29jgok9ScjC6U5YfYcTGppJfjkCtpUI88urx6AUTzKDFGOavi5XM=");
            channelParams.put("pinKSN","10033A10C58049C000B2");
            channelParams.put("encryptedPin","0DE9E3F129A498D2");

            req.setChannelParams(channelParams);

            Result<PaymentOrder> result = TradeRepository.cardPayment(req);
            LoadingUtils.dismissLoading();
            if (result.isSuccess()) {
                if (result.getData() != null) {
                    PaymentOrder paymentOrder = result.getData();
                    runOnUiThread(() -> {
                        mTextResult.setText(GsonUtils.getGson4LogUtils().toJson(paymentOrder));
                    });
                    TokenCache.saveOrderId(paymentOrder.getId());
                } else  {
                    runOnUiThread(() -> {
                        mTextResult.setText("Card payment success");
                    });
                }
            } else  {
                String error = result.getError().getMessage();
                runOnUiThread(() -> {
                    mTextResult.setText("Card payment failed: " + error);
                });
            }
        });
    }
    private void card2ndAuth() {
       LoadingUtils.showLoading(this, "Card 2nd Auth...");
        ThreadPoolManager.executeCacheTask(() -> {
            CardAuthorizationReq req = new CardAuthorizationReq();
            TokenAndPaymentOrderId tokenAndPaymentOrderId = new TokenAndPaymentOrderId();
            tokenAndPaymentOrderId.setToken(TokenCache.getToken());
            tokenAndPaymentOrderId.setPaymentOrderId(TokenCache.getOrderId()); //from cadPayment response
            req.setAuth2Result("FAILURE"); //SUCCESS or FAILURE
            req.setTokenAndPaymentOrderId(tokenAndPaymentOrderId);
           Result<PaymentOrder> result = TradeRepository.card2ndAuth(req);
            LoadingUtils.dismissLoading();
            if (result.isSuccess()) {
                runOnUiThread(() -> {
                    if (result.getData() == null) {
                        mTextResult.setText("Card 2nd auth success");
                    } else  {
                       mTextResult.setText(GsonUtils.getGson4LogUtils().toJson(result.getData()));
                    }
                });
            } else  {
                String error = result.getError().getMessage();
                runOnUiThread(() -> {
                    mTextResult.setText("Card 2nd auth failed: " + error);
                });
            }
        });
    }
    private void inquiryCashier() {
       LoadingUtils.showLoading(this, "Inquiry Cashier...");
        ThreadPoolManager.executeCacheTask(() -> {
            InquiryCashierReq req = new InquiryCashierReq();
            req.setToken(TokenCache.getToken()); //from original placeOrder response
            Result<CashierOrder> result = TradeRepository.inquiryCashier(req);
            LoadingUtils.dismissLoading();
            if (result.isSuccess()) {
                runOnUiThread(() -> {
                    if (result.getData() == null) {
                        mTextResult.setText("Inquiry cashier success");
                    } else  {
                        mTextResult.setText(GsonUtils.getGson4LogUtils().toJson(result.getData()));
                    }
                });
            } else  {
                String error = result.getError().getMessage();
                runOnUiThread(() -> {
                    mTextResult.setText("Inquiry cashier failed: " + error);
                });
            }
        });
    }
    private void closeCashier() {
        token = TokenCache.getToken();
        LoadingUtils.showLoading(this, "Close Cashier...");
        ThreadPoolManager.executeCacheTask(() -> {
            CloseCashierReq req = new CloseCashierReq();
            req.setToken(token); // token from placeOrder response
            Result<Object> result = TradeRepository.closeCashier(req);
            LoadingUtils.dismissLoading();
            if (result.isSuccess()) {
                runOnUiThread(() -> {
                   //close cashier response is empty, still show success
                    mTextResult.setText("Close cashier success");
                });
            } else  {
                String error = result.getError().getMessage();
                runOnUiThread(() -> {
                    mTextResult.setText("Close cashier failed: " + error);
                });
            }
        });
    }
    private void revokeOrder() {
        LoadingUtils.showLoading(this, "Revoke Order...");
        ThreadPoolManager.executeCacheTask(() -> {
            RevokeOrderReq req = new RevokeOrderReq();
            OrderIndex orderIndex = new OrderIndex();
            orderIndex.setOrderNo(TokenCache.getOrderNo()); //from original placeOrder response
            req.setAcquireOrderId(orderIndex);        //from original placeOrder response
            Result<RevokeOrderResponse> result = TradeRepository.revokeOrder(req);
            LoadingUtils.dismissLoading();
            if (result.isSuccess()) {
                runOnUiThread(() -> {
                    if (result.getData() == null) {
                        mTextResult.setText("Revoke order success");
                    } else  {
                        mTextResult.setText(GsonUtils.getGson4LogUtils().toJson(result.getData()));
                    }
                });
            } else  {
                String error = result.getError().getMessage();
                runOnUiThread(() -> {
                    mTextResult.setText("Revoke order failed: " + error);
                });
            }
        });
    }
    private void showMerchantQRCode() {
        LoadingUtils.showLoading(this, "Show Merchant QR Code...");
        ThreadPoolManager.executeCacheTask(()->{
            token = TokenCache.getToken(); //from original placeOrder response
            Result<String> result = TradeRepository.showMerchantQRCode(token);
            LoadingUtils.dismissLoading();
            if (result.isSuccess()) {
                runOnUiThread(() -> {
                    mTextResult.setText(result.getData());
                    //create QR code image with result.getData()
                });
            } else {
                String error = result.getError().getMessage();
                runOnUiThread(() -> {
                    mTextResult.setText("Show merchant QR code failed: " + error);
                });
            }
        });
    }
    private void scanCustomerQRCode() {
        LoadingUtils.showLoading(this, "Scan Customer QR Code...");
        ThreadPoolManager.executeCacheTask(()->{
            ScanCustomerQRCodeReq req = new ScanCustomerQRCodeReq();
            req.setToken(TokenCache.getToken()); //from original placeOrder response
            req.setQrCode("https://qr.alipay.com/bax00007qzqzqzqzqzqzqz"); //scan from customer
            req.setDeviceLatitude("24.495811019518776"); //get from GPS or network
            req.setDeviceLongitude("54.40854299999998"); //get from GPS or network

            Result<PaymentInteraction> result = TradeRepository.scanCustomerQRCode(req);
            LoadingUtils.dismissLoading();
            if (result.isSuccess()) {
                runOnUiThread(() -> {
                    mTextResult.setText(GsonUtils.getGson4LogUtils().toJson(result.getData()));
                });
            } else {
                String error = result.getError().getMessage();
                runOnUiThread(() -> {
                    mTextResult.setText("Scan customer QR code failed: " + error);
                });
            }
        });
    }
    private void inquiryPaymentOrder() {
        LoadingUtils.showLoading(this, "Inquiry Payment Order...");
        ThreadPoolManager.executeCacheTask(()->{
            InquiryPaymentOrderReq req = new InquiryPaymentOrderReq();
            req.setPaymentRequestNo(TokenCache.getPaymentRequestNo()); //from original payment order
            req.setToken(TokenCache.getToken()); //from original payment order
            Result<PaymentOrder> result = TradeRepository.inquiryPaymentOrder(req);
            LoadingUtils.dismissLoading();
            if (result.isSuccess()) {
                runOnUiThread(() -> {
                    mTextResult.setText(GsonUtils.getGson4LogUtils().toJson(result.getData()));
                });
            } else {
                String error = result.getError().getMessage();
                runOnUiThread(() -> {
                    mTextResult.setText("Inquiry payment order failed: " + error);
                });
            }
        });
    }
}
