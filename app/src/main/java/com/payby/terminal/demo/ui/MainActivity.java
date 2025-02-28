package com.payby.terminal.demo.ui;

import android.app.ComponentCaller;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.king.camera.scan.CameraScan;
import com.payby.terminal.demo.R;
import com.payby.terminal.demo.store.ActiveCache;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        boolean isActive = ActiveCache.getActiveCache();
        if (isActive) {
            HomePageActivity.startAction(this);
            finish();// do something
        }
    }
    private void initView() {
        findViewById(R.id.button_active_terminal).setOnClickListener(v -> {
           ScanActivity.startAction(this);
        });
    }

}
