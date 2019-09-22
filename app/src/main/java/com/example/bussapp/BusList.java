package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bussapp.AdminRoute.RouteDetails;
import com.example.bussapp.UserPassenger.UserPassengerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BusList extends AppCompatActivity {

    RecyclerView passenger_avail_bus;
    UserPassengerAdapter userPassengerAdapter;
    List<RouteDetails> routeDetailsList;
    DatabaseReference reference;
    Query query;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);

        routeDetailsList = new ArrayList<RouteDetails>();
        passenger_avail_bus=(RecyclerView)findViewById(R.id.passenger_avail_bus);
        passenger_avail_bus.setHasFixedSize(true);
        passenger_avail_bus.setLayoutManager(new LinearLayoutManager(this));
        reference= FirebaseDatabase.getInstance().getReference();//child("Routes_Data");
       Query query = reference.child("Routes_Data").orderByChild("from").equalTo("Kandy");
      //  Query query = reference.orderByChild("startTime").startAt(9).endAt(9).orderByChild("from").startAt("Mathara").endAt("Mathara");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    RouteDetails routeDetails= dataSnapshot1.getValue(RouteDetails.class);
                    routeDetailsList.add(routeDetails);
                   // Log.i("DataFromFire",routeDetails.getFrom().toString());
                }
                userPassengerAdapter=new UserPassengerAdapter(BusList.this,routeDetailsList);
                passenger_avail_bus.setAdapter(userPassengerAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(BusList.this,"No Route Data Found",Toast.LENGTH_LONG).show();

            }
        });
    }

    /*public void Selectbtnclick(View v) {
        Intent intent3 = new Intent(BusList.this, SelectSeat.class);
        startActivity(intent3);

    }*/
}
