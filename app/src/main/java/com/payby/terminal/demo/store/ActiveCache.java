package com.payby.terminal.demo.store;

import android.content.Context;
import android.content.SharedPreferences;

import com.payby.terminal.demo.App;

public class ActiveCache {
    private static final String FILE_NAME = "active_cache";
    private static final String KEY_ACTIVE_CACHE = "active_cache";

    private ActiveCache() {}

    public static void saveActiveCache(boolean activeCache) {
        SharedPreferences preferences = getSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(KEY_ACTIVE_CACHE, activeCache);
        editor.commit();
    }

    public static boolean getActiveCache() {
        SharedPreferences preferences = getSharedPreferences();
        return preferences.getBoolean(KEY_ACTIVE_CACHE, false);
    }

    private static SharedPreferences getSharedPreferences() {
        return App.instance.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }
}
