package com.payby.terminal.demo.store;

import android.content.Context;
import android.content.SharedPreferences;

import com.payby.terminal.demo.App;

public class TokenCache {
    private static final String  FILE_NAME = "token_cache";
    private static final String  KEY_CACHE_TOKEN = "cache_token";
    private static final String  KEY_CACHE_REQUEST_NO = "cache_payment_request_no";
    private static final String  KEY_CACHE_ORDER_ID = "cache_order_id";
    private static final String  KEY_CACHE_MERCHANT_ORDER_NO = "cache_merchant_order_no";
    private static final String  KEY_CACHE_ORDER_NO = "cache_cache_order_no";

    private TokenCache() {}

    public static void saveToken(String token) {
        SharedPreferences preferences = getSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_CACHE_TOKEN, token);
        editor.commit();
    }
    public static String getToken() {
        SharedPreferences preferences = getSharedPreferences();
        return preferences.getString(KEY_CACHE_TOKEN, "");
    }

    public static void savePaymentRequestNo(String uuid) {
        SharedPreferences preferences = getSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_CACHE_REQUEST_NO, uuid);
        editor.commit();
    }
    public static String getPaymentRequestNo() {
        SharedPreferences preferences = getSharedPreferences();
        return preferences.getString(KEY_CACHE_REQUEST_NO, "");
    }

    public static void saveOrderId(String orderId) {
        SharedPreferences preferences = getSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_CACHE_ORDER_ID, orderId);
        editor.commit();
    }
    public static String getOrderId() {
        SharedPreferences preferences = getSharedPreferences();
        return preferences.getString(KEY_CACHE_ORDER_ID, "");
    }

    public static void saveMerchantOrderNo(String merchantOrderNo) {
        SharedPreferences preferences = getSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_CACHE_MERCHANT_ORDER_NO, merchantOrderNo);
        editor.commit();
    }
    public static String getMerchantOrderNo() {
        SharedPreferences preferences = getSharedPreferences();
        return preferences.getString(KEY_CACHE_MERCHANT_ORDER_NO, "");
    }


    public static void saveOrderNo(String orderNo) {
        SharedPreferences preferences = getSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_CACHE_ORDER_NO, orderNo);
        editor.commit();
    }
    public static String getOrderNo() {
        SharedPreferences preferences = getSharedPreferences();
        return preferences.getString(KEY_CACHE_ORDER_NO, "");
    }


    private static SharedPreferences getSharedPreferences() {
        return App.instance.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

}
