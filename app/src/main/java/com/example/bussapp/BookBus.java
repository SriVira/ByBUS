package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bussapp.Class.SearchBus;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BookBus extends AppCompatActivity {

    EditText txtFrom,txtTo,txtDate,txtTime;
    Button btnSearch;
    DatabaseReference DBRef;
    SearchBus srchBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_bus);
/*
        txtFrom=findViewById(R.id.txtFrom);
        txtTo=findViewById(R.id.txtTo);
        txtDate=findViewById(R.id.txtDate);
        txtTime=findViewById(R.id.txtTime);
        btnSearch=findViewById(R.id.btnSearch);
*/
        srchBus=new SearchBus();

       /* DBRef = FirebaseDatabase.getInstance().getReference().child("Routes_Data");
        DBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    txtFrom.setText(dataSnapshot.child("from").getValue().toString());
                    txtTo.setText(dataSnapshot.child("to").getValue().toString());
                    txtTime.setText(dataSnapshot.child("startTime").getValue().toString());
                }else
                    Toast.makeText(getApplicationContext(),"No Bus to Dislpay",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

      */


    }

    public void Searchbtnclick(View v){
        Intent intent2 = new Intent(BookBus.this,BusList.class);
        startActivity(intent2);
    }
}
