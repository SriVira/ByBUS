package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class driver_dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_dashboard);

    }

    public void add_route(View v) {
        Intent i = new Intent(driver_dashboard.this, Add_route.class);
        startActivity(i);
    }

    public void booking(View v) {
        Intent i = new Intent(driver_dashboard.this, booking.class);
        startActivity(i);
    }

    public void payments(View v) {
        Intent i = new Intent(driver_dashboard.this, Payments.class);
        startActivity(i);


    }

    public void my_routes(View v) {
        Intent i = new Intent(driver_dashboard.this, My_route.class);
        startActivity(i);
    }
}
