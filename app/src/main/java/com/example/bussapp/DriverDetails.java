package com.example.bussapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DriverDetails extends AppCompatActivity {

    Button update,delete;
    EditText driverName, dLicenceNo, contactNo,busNo,seatsCount,email;
    DatabaseReference dbref;
    DriverProfile dp;
    DatabaseReference ref;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_details);


        ref = FirebaseDatabase.getInstance().getReference().child("RegisterDetails").child("Driver").child("-LpPDqxo4RxsZaJsa8lT");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                email.setText(dataSnapshot.child("email").getValue().toString());
                driverName.setText(dataSnapshot.child("driverName").getValue().toString());
                contactNo.setText(dataSnapshot.child("contactNo").getValue().toString());
                busNo.setText(dataSnapshot.child("busNo").getValue().toString());
                seatsCount.setText(dataSnapshot.child("seatsCount").getValue().toString());
                dLicenceNo.setText(dataSnapshot.child("driverLicensNo").getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        driverName = findViewById(R.id.dName_DDetails);
        dLicenceNo=findViewById(R.id.DrivingL_DDetails);
        contactNo=findViewById(R.id.phoneNo_DDetails);
        busNo = findViewById(R.id.busNo_DDetails);
        email = findViewById(R.id.email_DDetails);
        seatsCount=findViewById(R.id.seatCount_DDetails);

        update = findViewById(R.id.Update_DDetails);
        dp = new DriverProfile();
        dbref = FirebaseDatabase.getInstance().getReference().child("RegisterDetails").child("Driver").child("-LpPDqxo4RxsZaJsa8lT");

        update.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          dp.setBusNo(busNo.getText().toString().trim());
                                          dp.setDriverName(driverName.getText().toString().trim());
                                          dp.setContactNo(Integer.parseInt(contactNo.getText().toString().trim()));
                                          dp.setEmail(email.getText().toString().trim());
                                          dp.setDriverLicensNo(dLicenceNo.getText().toString().trim());
                                          dp.setSeatsCount(seatsCount.getText().toString().trim());
                                          dbref.setValue(dp);
                                          Toast.makeText(DriverDetails.this, "Add Driver Details Successfull", Toast.LENGTH_SHORT).show();

                                      }
                                  }
        );



    }
}
