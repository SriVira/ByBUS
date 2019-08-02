package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class BusList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);
    }

    public void Selectbtnclick(View v) {
        Intent intent3 = new Intent(BusList.this, SelectSeat.class);
        startActivity(intent3);

    }
}
