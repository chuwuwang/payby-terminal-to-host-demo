package com.payby.terminal.demo.http;

import com.google.gson.Gson;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpWrapper {
    private static final Gson gson = new Gson();
    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    private static final long DEFAULT_TIMEOUT = 50L;
    private static OkHttpClient okHttpClient;

    static {
        initOkHttpClient();
    }

    private OkHttpWrapper() {}

    private static void initOkHttpClient () {
        SSLSocketFactory sslSocketFactory = null;
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{x509TrustManager};
            SecureRandom secureRandom = new SecureRandom();
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, secureRandom);
            sslSocketFactory = sslContext.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .hostnameVerifier((hostname, session) -> true)
                .followRedirects(false)
                .followSslRedirects(false);

        if (sslSocketFactory != null && x509TrustManager != null) {
            builder.sslSocketFactory(sslSocketFactory, x509TrustManager);
        }

        okHttpClient = builder.build();
    }

    private static final X509TrustManager x509TrustManager = new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
            // 不检查客户端证书
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
            // 不检查服务器证书
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0]; // 返回空数组
        }
    };

    public static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            throw new IllegalStateException("OkHttpClient is not initialized.");
        }
        return okHttpClient;
    }
}
