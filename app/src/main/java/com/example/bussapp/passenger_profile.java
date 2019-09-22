package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bussapp.Class.PassengerProfile;
import com.example.bussapp.Class.Register;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class passenger_profile extends AppCompatActivity {

    EditText txtPContact,txtPEmail,txtPName;
    Button btnPUpdate,btnPDeactivate;
    DatabaseReference DBRef,DBRef2;
    PassengerProfile profile;
    String Passenger;
    Register register;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passenger_profile);

        txtPName = findViewById(R.id.txtPName);
        txtPContact=findViewById(R.id.txtPContact);
        txtPEmail = findViewById(R.id.txtPEmail);
        btnPUpdate=findViewById(R.id.btnPUpdate);
        btnPDeactivate = findViewById(R.id.btnPDeactivate);

        mAuth = FirebaseAuth.getInstance();

        profile=new PassengerProfile();
        register = new Register();

        Intent intent2 = getIntent();
        Passenger =intent2.getStringExtra("UserName");


        DBRef = FirebaseDatabase.getInstance().getReference().child("RegisterDetails").child("Passenger");
        DBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        if (postSnapshot.child("email").getValue(String.class).equals("dileesha.dilee@gmail.com")) {
                            txtPName.setText(postSnapshot.child("name").getValue().toString());
                            txtPContact.setText(postSnapshot.child("conNo").getValue().toString());
                            txtPEmail.setText(postSnapshot.child("email").getValue().toString());


                        }
                        }
                } else {
                            Toast.makeText(getApplicationContext(), "No Source to Display", Toast.LENGTH_LONG).show();
                        }

                    }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }



        });
        UpdateProf();
        deleteProfile();
       // contactEmail();

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

                   // String PContact = txtPContact.getText().toString().trim();
                    String PEmail = txtPEmail.getText().toString().trim();

                    register.setName(txtPName.getText().toString().trim());
                    register.setConNo(Integer.parseInt(txtPContact.getText().toString()));
                    register.setEmail(txtPEmail.getText().toString().trim());
                    register.setPass("1234567");
                    register.setRadioButton1("Passenger");


                    if(!Patterns.EMAIL_ADDRESS.matcher(PEmail).matches()){
                        txtPEmail.setError("Please enter a valid email");
                        txtPEmail.requestFocus();
                        return;
                    //}else if(txtPContact.length()>10) {

                    }else{
                        Toast.makeText(getApplicationContext(), "Profile Updated Successfully", Toast.LENGTH_LONG).show();
                        DBRef2 = FirebaseDatabase.getInstance().getReference().child("RegisterDetails").child("Passenger").child("-LpNzCo8xj6aTnBn1RRn");
                        DBRef2.setValue(register);

                    }



                    //Toast.makeText(getApplicationContext(), "Profile Updated Successfully", Toast.LENGTH_LONG).show();

                    //contactEmail();
                    //registerUser();


                }catch (Exception ex){
                    txtPContact.setError("Maximum length of contact number should be 10");
                    txtPContact.requestFocus();
                    return;
                  // Toast.makeText(getApplicationContext(), "No Source to Update", Toast.LENGTH_LONG).show();

                }

            }

        }));

    }
    /*private void contactEmail(){
        String PContact = txtPContact.getText().toString().trim();
        String PEmail = txtPEmail.getText().toString().trim();

        if(!Patterns.EMAIL_ADDRESS.matcher(PEmail).matches()){
            txtPEmail.setError("Please enter a valid email");
            txtPEmail.requestFocus();
            return;
        }

    }*/





    public void deleteProfile(){
        btnPDeactivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DBRef = FirebaseDatabase.getInstance().getReference().child("RegisterDetails").child("Passenger").child("-LpNzCo8xj6aTnBn1RRn");
                    DBRef.removeValue();
                    Toast.makeText(getApplicationContext(), "Profile Deleted Successfully", Toast.LENGTH_LONG).show();

                }catch(Exception e) {
                    Toast.makeText(getApplicationContext(), "No Source to Delete", Toast.LENGTH_LONG).show();

            }

            }
        });
    }

}
