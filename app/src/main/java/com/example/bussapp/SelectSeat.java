package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bussapp.Class.BookSeat;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SelectSeat extends AppCompatActivity {

    EditText seatNo, txtSBusNo,txtSDName,txtSConNo,txtSfrom,txtSto,txtSDTime,txtSArTime,txtSBookedSeats,txtSAvailabeSeates;
    Button btnBookNow;
    BookSeat bSeat;
    TextView txtrouteNo;
    DatabaseReference DBRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_seat);


        final DatabaseReference DBRef;

        seatNo = findViewById(R.id.seatNo);
        btnBookNow = findViewById(R.id.btnBookNow);
        txtSBusNo = findViewById(R.id.txtSBusNo);
        txtSDName = findViewById(R.id.txtSDName);
        txtSConNo = findViewById(R.id.txtSConNo);
        txtSfrom = findViewById(R.id.txtSfrom);
        txtSto = findViewById(R.id.txtSto);
        txtSDTime = findViewById(R.id.txtSDTime);
        txtSArTime = findViewById(R.id.txtSArTime);
        txtSBookedSeats = findViewById(R.id.txtSBookedSeats);
        txtSAvailabeSeates = findViewById(R.id.txtSAvailabeSeates);
        txtrouteNo=findViewById(R.id.routeNo);


        GetRouteDetails();
        bSeat = new BookSeat();

        DBRef = FirebaseDatabase.getInstance().getReference().child("BookSeat");
        DBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



                btnBookNow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (TextUtils.isEmpty(seatNo.getText().toString()))
                            Toast.makeText(getApplicationContext(), "Please enter a seat number", Toast.LENGTH_SHORT).show();
                        else {
                            bSeat.setSeatNo(Integer.parseInt(seatNo.getText().toString().trim()));
                            bSeat.setTxtSfrom(txtSfrom.getText().toString().trim());
                            bSeat.setTxtSto(txtSto.getText().toString().trim());
                            bSeat.setTxtSDTime(txtSDTime.getText().toString().trim());
                            bSeat.setTxtSArTime(txtSArTime.getText().toString().trim());
                            bSeat.setTxtrouteNo(txtrouteNo.getText().toString().trim());
                            bSeat.setTxtSBusNo(txtSBusNo.getText().toString().trim());
                            bSeat.setTxtSDName(txtSDName.getText().toString().trim());
                            bSeat.setTxtSConNo(txtSConNo.getText().toString().trim());
                            bSeat.setTxtSBookedSeats(txtSBookedSeats.getText().toString().trim());
                            bSeat.setTxtSAvailabeSeates(txtSAvailabeSeates.getText().toString().trim());


                            DBRef.child(seatNo.getText().toString()).setValue(bSeat);
                            //DBRef.push().setValue(bSeat);

                            Intent intent2 = new Intent(SelectSeat.this, PayNow.class);
                            startActivity(intent2);
                        }
                    }
                });






        /*DatabaseReference DBRef = FirebaseDatabase.getInstance().getReference().child("");
        DBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    txtSBusNo.setText(dataSnapshot.child("").getValue().toString());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

         */


    }

    private void GetRouteDetails(){
        if(getIntent().hasExtra("RouteNo")){


            DBRef=FirebaseDatabase.getInstance().getReference().child("Routes_Data").child(getIntent().getStringExtra("RouteNo").toString());
            DBRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.hasChildren()){
                        txtSDTime.setText(dataSnapshot.child("startTime").getValue().toString());
                        txtSArTime.setText(dataSnapshot.child("endTime").getValue().toString());
                        txtSfrom.setText(dataSnapshot.child("from").getValue().toString());
                        txtSto.setText(dataSnapshot.child("to").getValue().toString());
                        txtrouteNo.setText(dataSnapshot.child("rnumber").getValue().toString());

                        Toast.makeText(SelectSeat.this,"Load Data Successfull",Toast.LENGTH_LONG);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }

}