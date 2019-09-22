package com.example.bussapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bussapp.Class.passenger_rating;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Ratings extends AppCompatActivity {

    RatingBar Passenger_ratingBar;
    Button btn_rating_submit;
    DatabaseReference DBRef;
    //com.example.bussapp.Class.passenger_rating passenger_rating;
    passenger_rating Passenger_rating;
    FirebaseDatabase firebaseDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);

        Passenger_ratingBar = findViewById(R.id.Passenger_ratingBar);
        btn_rating_submit=findViewById(R.id.btn_rating_submit);

        Passenger_rating = new passenger_rating();

        DBRef = FirebaseDatabase.getInstance().getReference().child("PassengerRate");
        DBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Rating();

    }

    public void Rating(){

        btn_rating_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Passenger_rating.setPassenger_ratingBar(Passenger_ratingBar.toString().trim());
                //DBRef.child(Passenger_ratingBar.toString()).setValue(Passenger_rating);
                DBRef.push().setValue(Passenger_rating);
                Toast.makeText(Ratings.this,"Thank You For Rating",Toast.LENGTH_LONG).show();

            }
        });

    }
}
