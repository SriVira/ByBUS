package com.example.bussapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class admin_dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        admin_showico ();

    }

    public void admin_showico () {

        ActionBar admin_showico =getSupportActionBar();
        admin_showico.setDisplayShowHomeEnabled(true);
        admin_showico.setIcon(R.mipmap.admin_icon);


    }
    @Override
    public void onBackPressed(){

        this.onPause();
    }

    public  void admin_click_bookings(View V){

        Intent admin_click_bookings =new Intent(this, admin_bookings.class);
        startActivity(admin_click_bookings);
    }

    public  void admin_click_passengers(View V){
        Intent admin_click_passengers =new Intent(this,admin_pasengers.class);
        startActivity(admin_click_passengers);
    }

    public  void admin_click_drivers(View V){
        Intent admin_click_drivers =new Intent(this,admin_drivers.class);
        startActivity(admin_click_drivers);
    }

    public  void admin_click_routes(View V){
        Intent admin_click_routes =new Intent(this,admin_routes.class);
        startActivity(admin_click_routes);


    }

    public  void admin_click_payments(View V){
        Intent admin_click_payments =new Intent(this, admin_payments.class);
        startActivity(admin_click_payments);
    }

    public  void admin_click_settings(View V){
        Intent admin_click_settings =new Intent(this,admin_settings.class);
        startActivity(admin_click_settings);
    }

    public  void admin_click_logout(View V){
        Intent admin_click_logout =new Intent(this,user_login.class);
        startActivity(admin_click_logout);
        finish();
    }

}
