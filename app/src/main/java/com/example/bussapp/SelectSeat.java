package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SelectSeat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_seat);
    }

    public void BookNowbtnclick(View v) {
        Intent intent2 = new Intent(SelectSeat.this,PayNow.class);
        startActivity(intent2);
    }
}
