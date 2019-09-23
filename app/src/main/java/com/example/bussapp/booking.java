package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class booking extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<Booking_details> Blist;
    BookingAdpter_Driver adapter1;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        Blist = new ArrayList<Booking_details>();

        recyclerView =  findViewById(R.id.Booking_list_RV);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        reference = FirebaseDatabase.getInstance().getReference().child("BookSeat");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //List<String> bookings= new ArrayList<>();
                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){
                    Booking_details bookings = dataSnapshot1.getValue(Booking_details.class);
                    Blist.add(bookings);
                }
                adapter1 = new BookingAdpter_Driver(booking.this,Blist);
                recyclerView.setAdapter(adapter1);
            }

            //@Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(booking.this,"Something went to wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
