package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bussapp.Class.Register;
import com.google.firebase.FirebaseException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class user_register extends AppCompatActivity {

    EditText Name, ConNo, Email, Pass;
    Button reg;
    Register register;
    DatabaseReference DBRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_register);

        Name = findViewById(R.id.Name);
        ConNo= findViewById(R.id.ConNo);
        Email= findViewById(R.id.Email);
        Pass = findViewById(R.id.RegPassword);
        reg = findViewById(R.id.Reg);



        register = new Register();
        DBRef = FirebaseDatabase.getInstance().getReference().child("RegisterDetails");
        DBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           try {

                register.setName(Name.getText().toString().trim());
                register.setConNo(Integer.parseInt(ConNo.getText().toString().trim()));
                register.setEmail(Email.getText().toString().trim());
                register.setPass(Pass.getText().toString().trim());

                DBRef.child(Name.getText().toString()).setValue(register);

                Toast.makeText(user_register.this, "Registered Successfully", Toast.LENGTH_LONG).show();
            }catch(Exception ex){

                Toast.makeText(user_register.this,ex.getMessage().toString(),Toast.LENGTH_LONG).show();
            }

            }
        });


    }

    public  void gotoLogin(View v){

        Intent intent1 = new Intent(user_register.this, user_login.class);
        startActivity(intent1);
    }
}
