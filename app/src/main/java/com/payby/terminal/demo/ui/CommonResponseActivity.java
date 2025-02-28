package com.payby.terminal.demo.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.payby.terminal.demo.R;
import com.payby.terminal.demo.http.Result;
import com.payby.terminal.demo.http.entity.Money;
import com.payby.terminal.demo.http.entity.PaymentOrder;
import com.payby.terminal.demo.http.entity.TokenAndPaymentOrderId;
import com.payby.terminal.demo.http.entity.trade.PaymentInteraction;
import com.payby.terminal.demo.http.request.CardAuthorizationReq;
import com.payby.terminal.demo.http.request.CardPaymentReq;
import com.payby.terminal.demo.http.request.CloseCashierReq;
import com.payby.terminal.demo.http.request.InquiryCashierReq;
import com.payby.terminal.demo.http.request.InquiryPaymentOrderReq;
import com.payby.terminal.demo.http.request.PlaceOrderReq;
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
            PlaceOrderReq req = new PlaceOrderReq();
            Money totalAmount = new Money();
            totalAmount.setAmount(BigDecimal.valueOf(10.0));
            totalAmount.setCurrency("AED");
            req.setTotalAmount(totalAmount);
            req.setMerchantOrderNo(UUID.randomUUID().toString());
            req.setSubject("Purchase AED "+req.getTotalAmount().getAmount()+" at Test StoreName");
            Result<PlaceOrderResponse> result= TradeRepository.placeOrder(req);
            LoadingUtils.dismissLoading();
            if (result.isSuccess()) {
                runOnUiThread(() -> {
                    if (result.getData()!= null) {
                        token = result.getData().getToken();
                        TokenCache.saveToken(token);
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
            CardPaymentReq req = new CardPaymentReq();
            req.setToken(TokenCache.getToken());
            req.setCardMaskNo("549211 * *****3233");
            req.setPaymentRequestNo(UUID.randomUUID().toString());
            req.setDeviceLatitude("24.495811019518776"); //get from GPS or network
            req.setDeviceLongitude("54.40854299999998");

            Map<String, Object> channelParams = new HashMap<>();
            channelParams.put("readType", "CONTACTLESS");
            channelParams.put("passwordMode", "NO_PASSWORD");
            channelParams.put("isSignature", false);
            channelParams.put("mcSingleTapPin", false);
            channelParams.put("isFallbackTransaction", false);
            channelParams.put("isMagneticTransaction", false);
            channelParams.put("aid", "A0000000031010");
            channelParams.put("auth2", "false");
            //read from card
            channelParams.put("iccData", "500A4D41535445524341524482021B808407A0000000041010950500000080019A032502289C01005F2A0207845F3401009F02060000000001009F03060000000000009F080200029F090200029F0D05B4508400009F0E0500000000009F0F05B4708480009F10120114A14003020000000400000000000000FF9F1A0207849F1E0830303030303930359F26086E18E3BE05D3BFA09F2701809F3303E008E89F34033F00029F3501229F360200769F3704A71BDFD39F6E0707840000323100");
            channelParams.put("dssKSN","10033A10C58049C000AE");
            channelParams.put("encryptedDssData","xQwH6IUmcp7IB2Cg5yZRrBCags9wwzNCXPleo9NszVgv7KPsTO5gb5QWcDXOFwtBFECOwG9gyNbGPDMJbWiDV8VVHFo/VfGJJB1hfTU4OC7buE//k70hlXI6487OoGWGRmyr06AtkIOtMf04aSNQf1wmnVBJ55n/x0nu9gpZUQ5M5KQQ93Q44g==");
            req.setChannelParams(channelParams);

            Result<PaymentOrder> result = TradeRepository.cardPayment(req);
            LoadingUtils.dismissLoading();
            if (result.isSuccess()) {
                if (result.getData() != null) {
                    PaymentOrder paymentOrder = result.getData();
                    runOnUiThread(() -> {
                        mTextResult.setText(GsonUtils.getGson4LogUtils().toJson(paymentOrder));
                    });
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
            tokenAndPaymentOrderId.setPaymentOrderId("311740727239127896");
            req.setAuth2Result("SUCCESS"); //SUCCESS or FAILURE
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
            Result<String> result = TradeRepository.closeCashier(req);
            LoadingUtils.dismissLoading();
            if (result.isSuccess()) {
                runOnUiThread(() -> {
                    if (result.getData() == null) {
                        mTextResult.setText("Close cashier success");
                    } else  {
                        mTextResult.setText(result.getData().toString());
                    }
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
            CloseCashierReq req = new CloseCashierReq();
            req.setToken(TokenCache.getToken()); //from original placeOrder response
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
            req.setPaymentOrderId(UUID.randomUUID().toString()); //from original payment order
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
