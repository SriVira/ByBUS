package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class BookBus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_bus);


    }

    public void Searchbtnclick(View v){
        Intent intent2 = new Intent(BookBus.this,BusList.class);
        startActivity(intent2);
    }
}
