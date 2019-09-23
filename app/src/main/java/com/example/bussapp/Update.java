package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Update extends AppCompatActivity {

    Button update;

    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Intent intent = getIntent();

        String rno = intent.getStringExtra("RouteNo");
       String from = intent.getStringExtra("from");
       String to = intent.getStringExtra("to");
      String etime = intent.getStringExtra("etime");
       String stime = intent.getStringExtra("stime");
       final String ID =intent.getStringExtra("ID");

       final EditText fromET,toET,etimeET,stimeET;

       final EditText rnoET = (EditText) findViewById(R.id.driver_rnumber);
      rnoET.setText(rno);
       fromET = (EditText) findViewById(R.id.driver_From);
        fromET.setText(from);
        toET = (EditText) findViewById(R.id.driver_to);
        toET.setText(to);
        etimeET = (EditText) findViewById(R.id.driver_etime);
        etimeET.setText(etime);
        stimeET = (EditText) findViewById(R.id.driver_stime);
        stimeET.setText(stime);



        update = findViewById(R.id.driver_Update_btn);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Driver_RouteDetails routeDetails = new Driver_RouteDetails();

                routeDetails.setFrom(fromET.getText().toString().trim());
                routeDetails.setTo(toET.getText().toString().trim());
                routeDetails.setStartTime(stimeET.getText().toString().trim());
                routeDetails.setEndTime(etimeET.getText().toString().trim());
                routeDetails.setRNumber(rnoET.getText().toString().trim());
                routeDetails.setID(ID);

                reference = FirebaseDatabase.getInstance().getReference().child("Driver_Route_Data");
                reference.child(ID).setValue(routeDetails);

                Toast.makeText(getApplicationContext(), "update succeseful",Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void update_route_button(){

    }
}
