package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class My_route extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_route);
    }

    public void Update(View V) {
        Intent Update = new Intent(My_route.this, Update.class);
        startActivity(Update);
    }
}
