package com.payby.terminal.demo.store;

import android.content.Context;
import android.content.SharedPreferences;

import com.payby.terminal.demo.App;

public class RSACache {

    private static final String FILE_NAME = "rsa_cache";
    private static final String KEY_RSA_PUBLIC = "rsa_public_cache";
    private static final String KEY_RSA_PRIVATE = "rsa_private_cache";

    //私有构造函数，防止实例化
    private RSACache() {}

    public static boolean isRSAKeysExist() {
        String publicKey = getPublicKey();
        String privateKey = getPrivateKey();
        if (publicKey.isEmpty() || privateKey.isEmpty()) {
            return false;
        } else  {
            return  true;
        }
    }

    public static void saveRSAKeys(String publicKey, String privateKey) {
        SharedPreferences preferences = getSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_RSA_PUBLIC, publicKey);
        editor.putString(KEY_RSA_PRIVATE, privateKey);
        editor.commit();
    }
    public static String getPublicKey() {
        SharedPreferences preferences = getSharedPreferences();
        return preferences.getString(KEY_RSA_PUBLIC, "");
    }

    public static String getPrivateKey() {
        SharedPreferences preferences = getSharedPreferences();
        return preferences.getString(KEY_RSA_PRIVATE, "");
    }

    public static void clear() {
        SharedPreferences preferences = getSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(KEY_RSA_PUBLIC);
        editor.remove(KEY_RSA_PUBLIC);
        editor.commit();
    }

    private static SharedPreferences getSharedPreferences() {
        return App.instance.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }
}
