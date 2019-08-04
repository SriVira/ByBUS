package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class booking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
    }

    public void Back2home(View v) {
        Intent Back2home = new Intent(booking.this, driver_dashboard.class);
        startActivity(Back2home);


    }
}
