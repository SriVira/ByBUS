package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Passenger extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger);
    }

    public void BookingImgBtnClick(View v){
        Intent intent1 = new Intent(Passenger.this,BookBus.class);
        startActivity(intent1);
    }
    public void MyBookingsImgBtnClick(View v){
        Intent intent2 = new Intent(Passenger.this,MyBookings.class);
        startActivity(intent2);
    }

    public void MyProfileImgBtnClick(View v){
        Intent intent4 = new Intent(Passenger.this,MyProfile.class);
        startActivity(intent4);
    }
    public void RatingImgBtnClick(View v){
        Intent intent5 = new Intent(Passenger.this,Ratings.class);
        startActivity(intent5);
    }
}
