package com.payby.terminal.demo.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.payby.terminal.demo.R;

public class LoadingDialog extends Dialog {
    private TextView messageTextView;
    private String message;

    public LoadingDialog(@NonNull Context context) {
        super(context, R.style.LoadingDialogStyle); // 自定义样式
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_loading, null);
        setContentView(view);

        messageTextView = view.findViewById(R.id.loading_message);
        ProgressBar progressBar = view.findViewById(R.id.loading_progress);

        // 设置默认属性
        setCancelable(false); // 默认不可取消
        setCanceledOnTouchOutside(false); // 点击外部不关闭

        // 设置消息（可选）
        if (message != null) {
            messageTextView.setText(message);
        } else {
            messageTextView.setVisibility(View.GONE);
        }
    }

    public void setMessage(String message) {
        this.message = message;
        if (messageTextView != null) {
            messageTextView.setText(message);
            messageTextView.setVisibility(View.VISIBLE);
        }
    }
}
