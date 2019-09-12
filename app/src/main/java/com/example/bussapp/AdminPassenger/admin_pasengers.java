package com.example.bussapp.AdminPassenger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.bussapp.Class.Register;
import com.example.bussapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class admin_pasengers extends AppCompatActivity {


    private static  final  String TAG ="admin_pasengers";
    RecyclerView recyclerView;
    PassengerAdapter passengerAdapter;
    List<Register> registerList;
    DatabaseReference DBRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_pasengers);

        registerList =new ArrayList<Register>();
        recyclerView =findViewById(R.id.passenger_recy_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DBRef = FirebaseDatabase.getInstance().getReference().child("RegisterDetails");


        DBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    Register register = dataSnapshot1.getValue(Register.class);
                    registerList.add(register);

                }

                passengerAdapter =new PassengerAdapter(admin_pasengers.this,registerList);
                recyclerView.setAdapter(passengerAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(admin_pasengers.this,"No Route Data Found.",Toast.LENGTH_LONG).show();
            }
        });


    }


}
