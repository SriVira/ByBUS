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

    public void onBackPressed(){

        this.onPause();
    }


    public void BookingImgBtnClick(View v){
        Intent BookingImgBtnClick = new Intent(Passenger.this,BookBus.class);
        startActivity(BookingImgBtnClick);
    }
    public void MyBookingsImgBtnClick(View v){
        Intent MyBookingsImgBtnClick = new Intent(Passenger.this,MyBookings.class);
        startActivity(MyBookingsImgBtnClick);
    }

    public void MyProfileImgBtnClick(View v){
        Intent MyProfileImgBtnClick = new Intent(Passenger.this,passenger_profile.class);
        startActivity(MyProfileImgBtnClick);
    }
    public void RatingImgBtnClick(View v){
        Intent RatingImgBtnClick = new Intent(Passenger.this,Ratings.class);
        startActivity(RatingImgBtnClick);
    }

}
