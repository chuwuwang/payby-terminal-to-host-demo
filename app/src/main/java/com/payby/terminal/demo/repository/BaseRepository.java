package com.payby.terminal.demo.repository;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.payby.terminal.demo.App;
import com.payby.terminal.demo.device.IssuerData;
import com.payby.terminal.demo.http.BaseResponse;
import com.payby.terminal.demo.http.CallProvider;
import com.payby.terminal.demo.http.ResponseCallback;
import com.payby.terminal.demo.http.Result;
import com.payby.terminal.demo.http.RetrofitWrapper;
import com.payby.terminal.demo.http.exception.GatewayException;
import com.payby.terminal.demo.http.exception.TerminalLocalException;
import com.payby.terminal.demo.utils.GsonUtils;
import com.payby.terminal.demo.utils.SignUtil;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

abstract public class BaseRepository {
    private static final String TAG = "gateway";

    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    private static final  PaybyService paybyService = RetrofitWrapper.createService();

    public static <T> Call<Object> deviceService(T req, String requestName) {
        RequestBody requestBody = createRequestBody(req, requestName);
        return paybyService.deviceService(requestBody);
    }

    public static <T> Call<Object> gatewayService(T req, String requestName) {
        RequestBody requestBody = createRequestBody(req, requestName);
        return paybyService.gatewayService(requestBody);
    }

    public static <T>Result<T> safeCall(Type type,java.util.function.Supplier<Call<Object>> call) {
        if (isNetworkConnected()) {
            onErrorResponse(new Throwable("No network"));
        }

        try {
            Response<Object> response = call.get().execute();
            if (!response.isSuccessful()) {
                String message = response.message();
                String code = String.valueOf(response.code());
                Log.e(TAG, "Response <--- code: " + code + " message: " + message);
                GatewayException exception = new GatewayException(code, message);
                return onErrorResponse(exception);
            }

            Object body = response.body();
            if (body == null) {
                TerminalLocalException exception = new TerminalLocalException("-101", "Response is empty");
                return onErrorResponse(exception);
            }
            String jsonString = GsonUtils.toJson(body);
            Log.e(TAG, "Response <--- body: " + jsonString);
            BaseResponse<T> obj = GsonUtils.fromJson(jsonString, type);

            if (obj.getHeader() == null) {
                TerminalLocalException exception = new TerminalLocalException("-102", "Response header is empty");
                return onErrorResponse(exception);
            }

            if (!"SUCCESS".equals(obj.getHeader().getResponseCode())) {
                Log.e(TAG, "Response <--- header: " + obj.getHeader());
                String traceCode = obj.getHeader().getTraceCode() != null ? obj.getHeader().getTraceCode() : "";
                String code = obj.getHeader().getResponseCode() != null ? obj.getHeader().getResponseCode() : "-103";
                String message = obj.getHeader().getErrorMessage() != null ? obj.getHeader().getErrorMessage() : "Server unknown error, please try again";

                if ("MERCHANT_DEVICE_NOT_FOUND".equals(code)) {

                    GatewayException exception = new GatewayException(code, "This device has been returned, please re-active.");
                    return onErrorResponse(exception);
                } else {
                    return onErrorResponse(new GatewayException(code, message + " - " + traceCode));
                }
            }
            T data = obj.getBody();
            Log.e(TAG, "Response <--- header: " + obj.getHeader() + " body: " + data);

            try {
                if (data != null) {
                    return Result.onSuccess(data);
                }

                T tData = createInstance(type);
                return Result.onSuccess(tData);
            } catch (Exception e) {
                e.printStackTrace();
                TerminalLocalException exception = new TerminalLocalException("-104", "POS serialization failure");
                return onErrorResponse(exception);
            }

        } catch (Exception e){
            e.printStackTrace();
            String message = e.getMessage() != null ? e.getMessage() : "Something has gone wrong";
            TerminalLocalException exception = new TerminalLocalException("-105", message);
            return onErrorResponse(exception);
        }

    }
    public static <T> Result<T> onErrorResponse(Throwable e) {
        return Result.onFailure(e);
    }
    private static <T> RequestBody createRequestBody(T body, String requestName) {
        Log.e(TAG, "Request ---> (api: " + requestName + ") " + body);

        Map<String, String> header = new HashMap<>();
        header.put("service", requestName);
        header.put("serviceVersion", "2.0");
        header.put("requestTime", getRequestTime());

        Map<String, Object> content = new HashMap<>();
        if (body != null) {
            content.put("body", body);
        }
        content.put("header", header);

        Map<String, Object> request = new HashMap<>();
        String contentString = GsonUtils.toJson(content);

        if ("active".equals(requestName)) {
            request.put("issuerCode", IssuerData.issuerCode);
        } else {
            Map<String, String> issuer = new HashMap<>();
            issuer.put("issuerCode", IssuerData.issuerCode);
            issuer.put("issuerType", IssuerData.issuerType);
            request.put("issuer", issuer);
        }

        request.put("content", contentString);
        request.put("signature", SignUtil.signature(contentString));
        request.put("signatureVersion", "2.0");

        String jsonString = GsonUtils.toJson(request);
        return RequestBody.create(MEDIA_TYPE_JSON, jsonString);
    }
    private static String getRequestTime() {
        String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        return new SimpleDateFormat(pattern).format(date);
    }

    private static boolean isNetworkConnected() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) App.instance.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private static <T> T createInstance(Type type) throws Exception {
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (T) ((Class<?>) rawType).getDeclaredConstructor().newInstance();
            }
        } else if (type instanceof Class) {
            return (T) ((Class<?>) type).getDeclaredConstructor().newInstance();
        }
        return null;
    }
}
