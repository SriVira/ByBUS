package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class driver_dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_dashboard);



    }
    public void onBackPressed(){

        this.onPause();
    }

    public void add_route(View v) {
        Intent add_route = new Intent(driver_dashboard.this,Add_route.class);
        startActivity(add_route);
    }

    public void booking(View v) {
        Intent booking = new Intent(driver_dashboard.this, booking.class);
        startActivity(booking);
    }

    public void payments(View v) {
        Intent payments = new Intent(driver_dashboard.this, Payments.class);
        startActivity(payments);


    }

    public void my_routes(View v) {
        Intent my_routes = new Intent(driver_dashboard.this, My_route.class);
        startActivity(my_routes);
    }
}
