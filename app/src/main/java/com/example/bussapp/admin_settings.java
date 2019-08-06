package com.example.bussapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class admin_settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_settings);
    }

    public void UpdateSuccessfulymsg(View v){

        Toast.makeText(this,"Update Success",Toast.LENGTH_SHORT).show();

    }
}
