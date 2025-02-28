package com.payby.terminal.demo.view;

import android.app.Activity;
import android.content.Context;

public class LoadingUtils {
    private static volatile LoadingDialog loadingDialog;
    private static final Object lock = new Object();
    private LoadingUtils() {
    }

    public static void showLoading(Context context, String msg) {
        if (context == null || (context instanceof Activity && ((Activity) context).isFinishing())) {
            return;
        }
        synchronized (lock) {
            dismissLoading(); // 先关闭现有对话框
            loadingDialog = new LoadingDialog(context);
            if (msg != null) {
                loadingDialog.setMessage(msg);
            }
            loadingDialog.show();
        }
    }

    // 隐藏 Loading
    public static void dismissLoading() {
        synchronized (lock) {
            if (loadingDialog != null && loadingDialog.isShowing()) {
                loadingDialog.dismiss();
                loadingDialog = null;
            }
        }
    }

    // 检查是否正在显示
    public static boolean isShowing() {
        return loadingDialog != null && loadingDialog.isShowing();
    }
}
