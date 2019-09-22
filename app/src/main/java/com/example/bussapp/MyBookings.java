package com.example.bussapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bussapp.AdminRoute.RouteDetails;
import com.example.bussapp.Class.BookSeat;
import com.example.bussapp.UserPassenger.UserPassengerAdapter;
import com.example.bussapp.UserPassenger.myBookings_Passenger_Adapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MyBookings extends AppCompatActivity {

    RecyclerView myb_recyclerView;
    myBookings_Passenger_Adapter myBookings_passenger_adapter;
    List<BookSeat>bookSeatList;
    DatabaseReference reference;
    Button myb_btn_delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bookings);


        bookSeatList = new ArrayList<BookSeat>();
        myb_recyclerView = (RecyclerView) findViewById(R.id.myb_recyclerView);
        myb_recyclerView.setHasFixedSize(true);
        myb_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        reference = FirebaseDatabase.getInstance().getReference().child("BookSeat");


        //deleteBookingDetails();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    BookSeat bookSeat = dataSnapshot1.getValue(BookSeat.class);
                    bookSeatList.add(bookSeat);
                    // Log.i("DataFromFire",routeDetails.getFrom().toString());
                }
                myBookings_passenger_adapter = new myBookings_Passenger_Adapter(MyBookings.this, bookSeatList);
                myb_recyclerView.setAdapter(myBookings_passenger_adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(MyBookings.this, "No Booking Data Found", Toast.LENGTH_LONG).show();

            }
        });
    }

}