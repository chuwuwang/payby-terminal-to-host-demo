package com.payby.terminal.demo.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.payby.terminal.demo.R;
import com.payby.terminal.demo.device.IssuerData;
import com.payby.terminal.demo.http.Result;
import com.payby.terminal.demo.http.request.ActiveReq;
import com.payby.terminal.demo.repository.TradeRepository;
import com.payby.terminal.demo.store.ActiveCache;
import com.payby.terminal.demo.store.RSACache;
import com.payby.terminal.demo.utils.ThreadPoolManager;
import com.payby.terminal.demo.view.LoadingUtils;

public class ActivePageActivity extends AppCompatActivity {
    public static void startAction(Context context, String code) {
        Intent intent = new Intent(context, ActivePageActivity.class);
        intent.putExtra("extra_code", code);
        context.startActivity(intent);
    }

    private TextView mTextResult;
    private TextView mTvActiveTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_page);
        initView();
        String code = getIntent().getStringExtra("extra_code");
        if (code != null && !code.isEmpty()) {
            startActive(code);
        } else  {
            mTvActiveTitle.setText("Active failed");
            mTextResult.setText("Active code is empty");
        }

    }

    private void initView() {
        mTextResult = findViewById(R.id.widget_tv_result);
        mTvActiveTitle = findViewById(R.id.widget_tv_active_title);
        findViewById(R.id.widget_btn_confirm).setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void startActive(String code) {
        LoadingUtils.showLoading(this, "Active terminal...");
        ThreadPoolManager.executeCacheTask(() -> {
            String pubKeyStr = RSACache.getPublicKey();
            ActiveReq req = new ActiveReq();
            req.setCode(code);
            req.setPosDeviceType(IssuerData.issuerType);
            req.setPubKey(new String(Base64.encode(pubKeyStr.trim().getBytes(), Base64.NO_WRAP)));
            Result<String> result = TradeRepository.activeTerminal(req);
            LoadingUtils.dismissLoading();
            if (result.isSuccess()) {
                ActiveCache.saveActiveCache(true);
                HomePageActivity.startAction(this);
                finish();
            } else  {
                String error = result.getError().getMessage();
                ActiveCache.saveActiveCache(false);

                runOnUiThread(() -> {
                    mTvActiveTitle.setText("Active failed");
                    mTextResult.setText(error);
                });
            }
        });
    }
}
