package com.example.bussapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
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

public class user_login extends AppCompatActivity implements View.OnClickListener {
    //final String Type2 = "Driver";
    String type;
    EditText UserName, UserPassword;
    TextView textViewForgot;
    Button login;
   // RadioButton radioButton;
    //RadioGroup radioGroup;
    FirebaseAuth firebaseAuth;
    DatabaseReference DBRef;
    DatabaseReference DBRef2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.user_login);

       findViewById(R.id.textViewSignup).setOnClickListener(this);
       textViewForgot = findViewById(R.id.textViewForgot);
       UserName = findViewById(R.id.UE);
       UserPassword = findViewById(R.id.PW);
       login = findViewById(R.id.login);
       firebaseAuth = FirebaseAuth.getInstance();




       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(UserName.getText().toString().isEmpty()){
                   UserName.setError("Email is required");
                   UserName.requestFocus();
                   return;
               }if (UserPassword.getText().toString().isEmpty()){
                   UserPassword.setError("Password is required");
                   UserPassword.requestFocus();
                   return;
               }

               if (UserName.getText().toString().equals("admin")&& UserPassword.getText().toString().equals("admin")) {
                   Intent intent = new Intent(user_login.this, admin_dashboard.class);
                   startActivity(intent);
                   return;
               }

               type = "WRONG";
               DBRef = FirebaseDatabase.getInstance().getReference().child("RegisterDetails").child("Passenger");
               DBRef.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       Log.i("Fires", dataSnapshot.toString() );
                       if (dataSnapshot.hasChildren()){
                           for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                               Log.i("FireChild", postSnapshot.toString() );
                               if( postSnapshot.child("email").getValue(String.class).toString().equals(UserName.getText().toString() )) {

                                   type = postSnapshot.child("radioButton1").getValue(String.class).toString();

                                  // Toast.makeText(user_login.this,"type is "+type,Toast.LENGTH_LONG).show();

                               }
                           }

                            //Toast.makeText(user_login.this,type1,Toast.LENGTH_LONG).show();

                       }
                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {

                   }
               });

               DBRef2 = FirebaseDatabase.getInstance().getReference().child("RegisterDetails").child("Driver");
               DBRef2.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       Log.i("Fires", dataSnapshot.toString() );

                       if (dataSnapshot.hasChildren()){
                           for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                               Log.i("FireChild", postSnapshot.toString() );
                               if( postSnapshot.child("email").getValue(String.class).toString().equals(UserName.getText().toString() )) {
                                   type = postSnapshot.child("radioButton2").getValue(String.class).toString();

                                   //Toast.makeText(user_login.this,"type is "+type,Toast.LENGTH_LONG).show();

                               }
                           }
                       }
                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {

                   }
               });

               firebaseAuth.signInWithEmailAndPassword(UserName.getText().toString(),UserPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful() && type.equals("Passenger")) {
                           startActivity(new Intent(user_login.this, Passenger.class));
                       }else if (task.isSuccessful() && type.equals("Driver") ){
                           startActivity(new Intent(user_login.this,driver_dashboard.class));
                       }else {
                           Toast.makeText(user_login.this,"Wrong Email or Password",Toast.LENGTH_LONG).show();
                       }

                   }
               });

           }
       });



       textViewForgot.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(user_login.this,user_password_reset.class));
           }
       });
}

  //  public void onBackPressed(){

   //     this.onPause();
  //  }

  //  public  void gotoRegister(View v){

   //     Intent intent1 = new Intent(user_login.this, user_register.class);
    //    startActivity(intent1);

  //  }

  //  public  void gotoForgot(View v){

    //    Intent intent4 = new Intent(user_login.this, user_password_reset.class);
    //    startActivity(intent4);
   // }

  //  public void loginCheck(View v){

    //   Uname = UserName.getText().toString();
     //  Upass = UserPassword.getText().toString();

     //   if(Uname.equals("admin") && Upass.equals("admin")){

       /*     Intent admin = new Intent(user_login.this, admin_dashboard.class);
            startActivity(admin);
            Toast.makeText(this,"Login Successfully As Admin",Toast.LENGTH_SHORT).show();

        }

        else if(Uname.equals("p") && Upass.equals("p")){

            Intent passenger = new Intent(user_login.this, Passenger.class);
            startActivity(passenger);
            Toast.makeText(this,"Login Successfully As Passenger",Toast.LENGTH_SHORT).show();
        }

        else if(Uname.equals("driver") && Upass.equals("driver")){

            Intent driver = new Intent(user_login.this,driver_dashboard.class);
            startActivity(driver);
            Toast.makeText(this,"Login Successfully As Driver",Toast.LENGTH_SHORT).show();

        }else{

            AlertDialog.Builder WronngUserPass = new AlertDialog.Builder(user_login.this);
            WronngUserPass.setCancelable(true);
            WronngUserPass.setTitle("Login");
            WronngUserPass.setMessage("Incorrect Username Or Password. Please Try Again");


            WronngUserPass.setPositiveButton("Try again", new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface dialog, int i) {

                    dialog.cancel();
                    UserName.setText("");
                    UserPassword.setText("");
                }
            });

            WronngUserPass.show();
        }


        } */



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textViewSignup:
                startActivity(new Intent(this, user_register.class));
                break;
        }
    }


}

