package com.example.bussapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class user_login extends AppCompatActivity {
    String Uname;
    String Upass;
    EditText UserName, UserPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);

       UserName = findViewById(R.id.UN);
       UserPassword = findViewById(R.id.PW);


}

    public void onBackPressed(){

        this.onPause();
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

       Uname = UserName.getText().toString();
       Upass = UserPassword.getText().toString();

        if(Uname.equals("admin") && Upass.equals("admin")){

            Intent admin = new Intent(user_login.this, admin_dashboard.class);
            startActivity(admin);
            finish();
        }

        else if(Uname.equals("passenger") && Upass.equals("passenger")){

            Intent passenger = new Intent(user_login.this, Passenger.class);
            startActivity(passenger);
            finish();
        }

        else if(Uname.equals("driver") && Upass.equals("driver")){

            Intent driver = new Intent(user_login.this,driver_dashboard.class);
            startActivity(driver);
            finish();

        }else{

            AlertDialog.Builder WronngUserPass = new AlertDialog.Builder(user_login.this);
            WronngUserPass.setCancelable(true);
            WronngUserPass.setTitle("Login");
            WronngUserPass.setMessage("Wrong Username Or Password. Please Try Again");


            WronngUserPass.setPositiveButton("Tryagain", new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface dialog, int i) {

                    dialog.cancel();
                    UserName.setText("");
                    UserPassword.setText("");
                }
            });

            WronngUserPass.show();
        }


        }



    }

