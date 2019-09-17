package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bussapp.Class.PassengerProfile;
import com.example.bussapp.Class.Register;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class passenger_profile extends AppCompatActivity {

    TextView txtPName,txtPContact,txtPEmail;
    Button btnPUpdate,btnPDeactivate;
    DatabaseReference DBRef;
    PassengerProfile profile;
    String Passenger;
    Register register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passenger_profile);

        txtPName = findViewById(R.id.txtPName);
        txtPContact=findViewById(R.id.txtPContact);
        txtPEmail = findViewById(R.id.txtPEmail);
        btnPUpdate=findViewById(R.id.btnPUpdate);
        btnPDeactivate = findViewById(R.id.btnPDeactivate);

        profile=new PassengerProfile();
        register = new Register();

        Intent intent2 = getIntent();
        Passenger =intent2.getStringExtra("UserName");


        DBRef = FirebaseDatabase.getInstance().getReference().child("RegisterDetails").child("dilee");
        DBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){

                    txtPName.setText(dataSnapshot.child("txtPName").getValue().toString());
                    txtPContact.setText(dataSnapshot.child("txtPContact").getValue().toString());
                    txtPEmail.setText(dataSnapshot.child("txtPEmail").getValue().toString());
                }else
                    Toast.makeText(getApplicationContext(),"No Source to Display",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        UpdateProf();
        deleteProfile();

                /*
                btnPUpdate.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        try {

                            profile.setTxtPName(txtPName.getText().toString().trim());
                            profile.setTxtPContact(txtPContact.getText().toString().trim());
                            profile.setTxtPEmail(txtPEmail.getText().toString().trim());

                            DBRef = FirebaseDatabase.getInstance().getReference().child("RegisterDetails").child("passenger");
                            DBRef.setValue(profile);
                            Toast.makeText(getApplicationContext(), "Profile Updated Successfully", Toast.LENGTH_LONG).show();


                        }catch (Exception ex){

                            Toast.makeText(getApplicationContext(), "No Source to Update", Toast.LENGTH_LONG).show();

                        }

                    }

                }));*/
/*
        btnPDeactivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBRef = FirebaseDatabase.getInstance().getReference().child("RegisterDetails");
                DBRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("Passenger")){
                            DBRef=FirebaseDatabase.getInstance().getReference().child("RegisterDetails").child("Passenger");
                            DBRef.removeValue();
                            Toast.makeText(getApplicationContext(),"Profile Deleted Successfully",Toast.LENGTH_LONG).show();

                        }else
                            Toast.makeText(getApplicationContext(),"No Source to Delete",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });*/


};

    public void UpdateProf(){

        btnPUpdate.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    profile.setTxtPName(txtPName.getText().toString().trim());
                    profile.setTxtPContact(txtPContact.getText().toString().trim());
                    profile.setTxtPEmail(txtPEmail.getText().toString().trim());

                    DBRef = FirebaseDatabase.getInstance().getReference().child("RegisterDetails").child("dilee");
                    DBRef.setValue(profile);
                    Toast.makeText(getApplicationContext(), "Profile Updated Successfully", Toast.LENGTH_LONG).show();


                }catch (Exception ex){

                    Toast.makeText(getApplicationContext(), "No Source to Update", Toast.LENGTH_LONG).show();

                }

            }

        }));






    }

    public void deleteProfile(){
        btnPDeactivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DBRef = FirebaseDatabase.getInstance().getReference().child("RegisterDetails").child("dilee");
                    DBRef.removeValue();
                    Toast.makeText(getApplicationContext(), "Profile Deleted Successfully", Toast.LENGTH_LONG).show();

                }catch(Exception e) {
                    Toast.makeText(getApplicationContext(), "No Source to Delete", Toast.LENGTH_LONG).show();

            }

            }
        });
    }

}
