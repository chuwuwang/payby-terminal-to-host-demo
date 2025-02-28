package com.payby.terminal.demo;

import android.app.Application;

import com.payby.terminal.demo.http.RetrofitWrapper;
import com.payby.terminal.demo.store.ActiveCache;
import com.payby.terminal.demo.store.RSACache;
import com.payby.terminal.demo.utils.RSAManager;

public class App extends Application {
    public static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        // step 1: check if RSA keys exist
        if (!RSACache.isRSAKeysExist()) {
            RSAManager.generateRSAKeys();
        }
        String simBaseUrl = "https://sim.test2pay.com/pos-gateway/";
        String uatBaseUrl = "https://uat.test2pay.com/pos-gateway/";
        RetrofitWrapper.initialize(simBaseUrl);
    }
}
