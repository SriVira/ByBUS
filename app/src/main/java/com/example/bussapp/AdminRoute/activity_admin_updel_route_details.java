package com.example.bussapp.AdminRoute;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bussapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class activity_admin_updel_route_details extends AppCompatActivity {

    EditText Rnum,StartTime,EndTime,From,To;
    TextView hide_routenum;
    Button DeleteRoute,UpdateRoute;
    RouteDetails routeDetails;
    DatabaseReference DBRef;
    DatabaseReference DBRefDel,DBUpdate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_updel_route_details);

        Rnum= findViewById(R.id.admin_rnumber_ud);
        StartTime =findViewById(R.id.admin_stime_ud);
        EndTime =findViewById(R.id.admin_etime_ud);
        From =findViewById(R.id.admin_from_ud);
        To =findViewById(R.id.admin_to_ud);
        hide_routenum =findViewById(R.id.hide_routenumber);
        routeDetails =new RouteDetails();

        DeleteRoute =findViewById(R.id.admin_delroute_btn);
        UpdateRoute = findViewById(R.id.admin_uproute_btn);

        GetRouteDetails();

        DeleteRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBRefDel = FirebaseDatabase.getInstance().getReference().child("Routes_Data").child(Rnum.getText().toString());
                DBRefDel.removeValue();
                ClearData();
                Toast.makeText(activity_admin_updel_route_details.this,"Delete Ok",Toast.LENGTH_LONG).show();
            }
        });

        UpdateRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{

                    routeDetails.setRNumber(Integer.parseInt(Rnum.getText().toString().trim()));
                    routeDetails.setFrom(From.getText().toString().trim());
                    routeDetails.setTO(To.getText().toString().trim());
                    routeDetails.setStartTime(StartTime.getText().toString().trim());
                    routeDetails.setEndTime(EndTime.getText().toString().trim());

                    DBUpdate =FirebaseDatabase.getInstance().getReference().child("Routes_Data").child(hide_routenum.getText().toString().trim());
                    DBUpdate.setValue(routeDetails);

                    ClearData();
                    Toast.makeText(activity_admin_updel_route_details.this, "Route Updated.", Toast.LENGTH_SHORT).show();


                }catch (Exception ex){

                    Toast.makeText(activity_admin_updel_route_details.this,ex.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void GetRouteDetails(){

        if(getIntent().hasExtra("RouteNumber")){

            hide_routenum.setText(getIntent().getStringExtra("RouteNumber"));
        Rnum.setText(getIntent().getStringExtra("RouteNumber"));}

        DBRef = FirebaseDatabase.getInstance().getReference().child("Routes_Data").child(getIntent().getStringExtra("RouteNumber").toString());

        DBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.hasChildren()){

                  StartTime.setText(dataSnapshot.child("startTime").getValue().toString());
                  EndTime.setText(dataSnapshot.child("endTime").getValue().toString());
                  From.setText(dataSnapshot.child("from").getValue().toString());
                  To.setText(dataSnapshot.child("to").getValue().toString());
                  Toast.makeText(activity_admin_updel_route_details.this,"Load Data Successful",Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private  void ClearData(){
        Rnum.setText("".trim());
        StartTime.setText("".trim());
        EndTime.setText("".trim());
        From.setText("".trim());
        To.setText("".trim());

    }
}
