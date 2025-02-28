package com.payby.terminal.demo.store;

import android.content.Context;
import android.content.SharedPreferences;

import com.payby.terminal.demo.App;

public class TokenCache {
    private static final String  FILE_NAME = "token_cache";
    private static final String  KEY_CACHE_TOKEN = "cache_token";

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

    private static SharedPreferences getSharedPreferences() {
        return App.instance.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

}
