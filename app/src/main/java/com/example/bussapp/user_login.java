package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class user_login extends AppCompatActivity {

    EditText UserName, UserPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);

       UserName = findViewById(R.id.UN);
       UserPassword = findViewById(R.id.PW);

}

    public  void gotoRegister(View v){

        Intent intent1 = new Intent(user_login.this, user_register.class);
        startActivity(intent1);
    }

    public  void gotoForgot(View v){

        Intent intent4 = new Intent(user_login.this, user_password_reset.class);
        startActivity(intent4);
    }

    public void loginCheck(View v){

        String Uname = UserName.getText().toString();
        String Upass = UserPassword.getText().toString();

        if(Uname.equals("admin")){

            Intent admin = new Intent(user_login.this, user_password_reset.class);
            startActivity(admin);
        }


        }



    }

