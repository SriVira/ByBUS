package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
                            DBRef.push().setValue(bSeat);
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

}