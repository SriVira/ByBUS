package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class user_register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_register);
    }

    public  void gotoLogin(View v){

        Intent intent1 = new Intent(user_register.this, user_login.class);
        startActivity(intent1);
    }
}
