package com.example.bussapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class admin_add_route extends AppCompatActivity {

    EditText From,To,StartTime,EndTime,Rnumber;
    Button AddRoute;
    DatabaseReference DBRef;
    RouteDetails routes;
    long RouteId=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_route);

        From = findViewById(R.id.admin_from);
        To = findViewById(R.id.admin_to);
        StartTime = findViewById(R.id.admin_stime);
        EndTime = findViewById(R.id.admin_etime);
        Rnumber =findViewById(R.id.admin_rnumber);
        AddRoute = findViewById(R.id.admin_addroute_btn);

        routes =new RouteDetails();
        DBRef = FirebaseDatabase.getInstance().getReference().child("Routes_Data");

        DBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        AddRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                routes.setFrom(From.getText().toString().trim());

                routes.setTO(To.getText().toString().trim());

                routes.setStartTime(StartTime.getText().toString().trim());

                routes.setEndTime(EndTime.getText().toString().trim());

                routes.setRNumber(Integer.parseInt(Rnumber.getText().toString().trim()));

                DBRef.push().setValue(routes);

                Toast.makeText(admin_add_route.this,"Route Added Done",Toast.LENGTH_LONG).show();
                Intent backtohome = new Intent(admin_add_route.this,admin_dashboard.class);
                startActivity(backtohome);


            }
        });






    }


}
