package com.example.bussapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class welcome_spalsh extends AppCompatActivity {


    private static int Splash_Time = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.welcome_splash);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent AdminPage = new Intent(welcome_spalsh.this,user_login.class);
                    startActivity(AdminPage);
                    finish();
                }
            },Splash_Time);

        }
    }

