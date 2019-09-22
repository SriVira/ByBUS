package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class  user_password_reset extends AppCompatActivity {

    EditText forgotEmail;
    Button forgotSend;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_password_reset);

        forgotEmail = findViewById(R.id.forgotEmail);
        forgotSend = findViewById(R.id.forgotSend);
        firebaseAuth = FirebaseAuth.getInstance();

        forgotSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(forgotEmail.getText().toString().isEmpty()){
                    forgotEmail.setError("Email is required");
                    forgotEmail.requestFocus();
                    return;
                }
                firebaseAuth.sendPasswordResetEmail(forgotEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(user_password_reset.this,"Password sent to your email",Toast.LENGTH_LONG).show();
                            Intent intent1 = new Intent(user_password_reset.this, user_login.class);
                            startActivity(intent1);
                        }else{
                            Toast.makeText(user_password_reset.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }

                    }
                });
            }
        });
    }

   // public  void gotoLogin(View v){


   // }
}
