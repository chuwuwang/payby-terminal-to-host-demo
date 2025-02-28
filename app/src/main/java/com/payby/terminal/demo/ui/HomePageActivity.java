package com.payby.terminal.demo.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.payby.terminal.demo.R;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener {

    public static void startAction(Context context) {
       Intent intent = new Intent(context, HomePageActivity.class);
       context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        initView();
    }
    private void initView() {
        findViewById(R.id.widget_btn_get_device_info).setOnClickListener(this);
        findViewById(R.id.widget_btn_place_order).setOnClickListener(this);
        findViewById(R.id.widget_btn_card_payment).setOnClickListener(this);
        findViewById(R.id.widget_btn_card_2nd_auth).setOnClickListener(this);
        findViewById(R.id.widget_btn_inquiry_cashier).setOnClickListener(this);
        findViewById(R.id.widget_btn_close_cashier).setOnClickListener(this);
        findViewById(R.id.widget_btn_revoke_order).setOnClickListener(this);
        findViewById(R.id.widget_btn_qr_code_payment).setOnClickListener(this);
        findViewById(R.id.widget_btn_scan_qr_code_payment).setOnClickListener(this);
        findViewById(R.id.widget_btn_inquiry_order).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
       if (view.getId() == R.id.widget_btn_get_device_info) {
           doTransaction(0);
       } else if (view.getId() == R.id.widget_btn_place_order) {
           doTransaction(1);
       } else if (view.getId() == R.id.widget_btn_card_payment) {
           doTransaction(2);
       } else if (view.getId() == R.id.widget_btn_card_2nd_auth) {
           doTransaction(3);
       } else if (view.getId() == R.id.widget_btn_inquiry_cashier) {
           doTransaction(4);
       } else if (view.getId() == R.id.widget_btn_close_cashier) {
            doTransaction(5);
       } else if (view.getId() == R.id.widget_btn_revoke_order) {
            doTransaction(6);
       } else if (view.getId() == R.id.widget_btn_qr_code_payment) {
            doTransaction(7);
       } else if (view.getId() == R.id.widget_btn_scan_qr_code_payment) {
            doTransaction(8);
       } else if (view.getId() == R.id.widget_btn_inquiry_order) {
            doTransaction(9);
       }
    }

    private void doTransaction(int nType) {
      CommonResponseActivity.startAction(this, nType);
    }
}
