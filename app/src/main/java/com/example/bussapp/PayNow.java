package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PayNow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_now);
    }

    public void CreditCrdbtnclick(View v) {
        Intent intent2 = new Intent(PayNow.this, CreditCardPay.class);
        startActivity(intent2);
    }
}
