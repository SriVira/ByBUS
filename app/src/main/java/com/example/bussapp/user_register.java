package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class user_register extends AppCompatActivity implements View.OnClickListener {

    EditText Name, ConNo, Email, Pass;
    Button reg;
    RadioButton radioButton1,radioButton2;
    RadioGroup radioGroup;
    Register register;



    DatabaseReference DBRef;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_register);

        Name = findViewById(R.id.Name);
        ConNo= findViewById(R.id.ConNo);
        Email= findViewById(R.id.Email);
        Pass = findViewById(R.id.RegPassword);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        //radioGroup = findViewById(R.id.radioGroup);
       // reg = findViewById(R.id.Reg);



        findViewById(R.id.Reg).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();


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

/*        reg.setOnClickListener(new View.OnClickListener() {
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
        });*/


    }
   /* public void computeMD5Hash(String password){
        try{
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(password.getBytes());
            byte messageDigest[] = digest.digest();

            StringBuffer MD5Hash = new StringBuffer();
            for (int i = 0; i < messageDigest.length;i++)
            {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while (h.length()<2)
                    h = "0"+h;
                MD5Hash.append(h);
            }

            result.setText(HD5Hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }*/


    public  void gotoLogin(View v){

        Intent intent1 = new Intent(user_register.this, user_login.class);
        startActivity(intent1);
    }

    private  void  registerUser(){
        String name = Name.getText().toString().trim();
        String email = Email.getText().toString().trim();
        String password = Pass.getText().toString().trim();
        String con = ConNo.getText().toString().trim();

        if(name.isEmpty()){
            Name.setError("Name is required");
            Name.requestFocus();
           return;
        }

        if(email.isEmpty()){
            Email.setError("Email is required");
            Email.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.setError("Please enter a valid email");
            Email.requestFocus();
            return;
        }

        if(password.isEmpty()){
            Pass.setError("Password is required");
            Pass.requestFocus();
            return;
        }



         if(password.length()<6){
             Pass.setError("Minimum length of password should be 6");
             Pass.requestFocus();
             return;
         }

         mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
             @Override
             public void onComplete(@NonNull Task<AuthResult> task) {
                 if (task.isSuccessful()){
                     Toast.makeText(getApplicationContext(), "Registered Successfully",Toast.LENGTH_LONG).show();
                     Intent intent = new Intent(user_register.this,user_login.class);
                     startActivity(intent);
                 } else{
                     Toast.makeText(user_register.this ,"Register Unsuccessful",Toast.LENGTH_LONG).show();
                 }

             }
         });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Reg:
                registerUser();
                break;

        }

        try {

            register.setName(Name.getText().toString().trim());
            register.setConNo(Integer.parseInt(ConNo.getText().toString().trim()));
            register.setEmail(Email.getText().toString().trim());
            register.setPass(Pass.getText().toString().trim());

            if(radioButton1.isChecked()) {
                register.setRadioButton1(radioButton1.getText().toString().trim());
                DBRef.child(radioButton1.getText().toString()).push().setValue(register);

            }
            if (radioButton2.isChecked()) {
                register.setRadioButton2(radioButton2.getText().toString().trim());
                DBRef.child(radioButton2.getText().toString()).push().setValue(register);
            }



           // DBRef.child(radioButton.getText().toString()).setValue(register);

           //
            //
            //
            //
            //
            //
            //
            //
            //
            // Toast.makeText(user_register.this, "Registered Successfully", Toast.LENGTH_LONG).show();
        }catch(Exception ex) {
            if (!Name.getText().toString().isEmpty() && Email.getText().toString().isEmpty() && Pass.getText().toString().isEmpty()) {
                 ConNo.setError("Number should have 10 digits");
                ConNo.requestFocus();
                 return;
                //Toast.makeText(user_register.this,ex.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        }

    }
}
