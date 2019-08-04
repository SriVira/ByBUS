package com.example.bussapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class admin_bookings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_bookings);

        admin_bookings_showico();

    }

    public void admin_bookings_showico () {

        ActionBar admin_bookings =getSupportActionBar();
        admin_bookings.setDisplayShowHomeEnabled(true);
        admin_bookings.setIcon(R.mipmap.admin_bookings_icon);


    }


}
