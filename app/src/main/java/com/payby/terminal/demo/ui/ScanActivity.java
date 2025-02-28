package com.payby.terminal.demo.ui;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.zxing.Result;
import com.king.camera.scan.AnalyzeResult;
import com.king.camera.scan.CameraScan;
import com.king.camera.scan.analyze.Analyzer;
import com.king.zxing.BarcodeCameraScanActivity;
import com.king.zxing.DecodeConfig;
import com.king.zxing.DecodeFormatManager;

public class ScanActivity extends BarcodeCameraScanActivity {
    public static void startAction(Context context) {
        Intent intent = new Intent(context, ScanActivity.class);
        context.startActivity(intent);
    }
    @Override
    public void initCameraScan(@NonNull CameraScan<Result> cameraScan) {
        super.initCameraScan(cameraScan);
        cameraScan.setPlayBeep(true);
    }

    @Nullable
    @Override
    public Analyzer<Result> createAnalyzer() {
        DecodeConfig decodeConfig = new DecodeConfig();
        decodeConfig.setHints(DecodeFormatManager.ALL_HINTS)
                .setFullAreaScan(false)
                .setAreaRectRatio(0.8f)
                .setAreaRectHorizontalOffset(0)
                .setAreaRectVerticalOffset(0);
        return super.createAnalyzer();
    }

    @Override
    public void onScanResultCallback(@NonNull AnalyzeResult<Result> result) {
        getCameraScan().setAnalyzeImage(false);
        Log.e("ScanActivity", "onScanResultCallback: " + result.getResult().getText());
        ActivePageActivity.startAction(this, result.getResult().getText());
        finish();
    }

    @Override
    public void onScanResultFailure() {
        super.onScanResultFailure();
    }
}
