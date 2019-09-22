package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bussapp.Class.Register;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Passenger extends AppCompatActivity {

    TextView welcomeName;
    DatabaseReference DBRef;
    Register register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger);

        welcomeName = findViewById(R.id.welcomeName);
        register=new Register();

        DBRef = FirebaseDatabase.getInstance().getReference().child("RegisterDetails").child("Passenger");
        DBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        if (postSnapshot.child("email").getValue(String.class).equals("dileesha.dilee@gmail.com")) {
                            welcomeName.setText(postSnapshot.child("name").getValue().toString());


                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        Intent intent = new Intent();
        intent.putExtra("UserName","passenger");
        //startActivity(intent);
    }

    //public void onBackPressed(){

        //this.onPause();
   // }


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
