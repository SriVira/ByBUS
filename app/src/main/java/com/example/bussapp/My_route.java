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

public class My_route extends AppCompatActivity {

    private static final String TAG= "My_Route";

    RecyclerView recyclerView;
    ArrayList<Driver_RouteDetails> Rlist;
    RouteAdapter adapter;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_route);

        Rlist = new ArrayList<Driver_RouteDetails>();

        recyclerView =  findViewById(R.id.recycleViewRoute);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        reference = FirebaseDatabase.getInstance().getReference().child("Driver_Route_Data");

       /*  reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    Driver_RouteDetails dreiverRouteDetails = new Driver_RouteDetails();

                   // dataSnapshot1.getValue(Driver_RouteDetails.class);
                    Rlist.add(dreiverRouteDetails);

                }
                adapter =new RouteAdapter(My_route.this,Rlist);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }); */
       reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               //List<String> routes= new ArrayList<>();
                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){
                    Driver_RouteDetails route = dataSnapshot1.getValue(Driver_RouteDetails.class);
                    Rlist.add(route);
                }
                adapter = new RouteAdapter(My_route.this,Rlist);
                recyclerView.setAdapter(adapter);
            }

            //@Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(My_route.this,"Something went to wrong", Toast.LENGTH_SHORT).show();
            }
        });



    }


    public void Update(View V) {
        Intent Update = new Intent(My_route.this, Update.class);
        startActivity(Update);
    }
}
  /*
  Routes_list =(ListView) findViewById(R.id.Routes_list);
        dbref = database.getReference("Driver_Route_Data");
  list =new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.routesCardView,R.id.routesDetails,list);
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    rdetails = ds.getValue(Driver_RouteDetails.class);
                    try{
                        list.add(rdetails.getRNumber() +" "+ rdetails.getFrom()+"-"+rdetails.getTo());
                    }catch(NullPointerException ignored){

                    }


                }
                Routes_list.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }); */