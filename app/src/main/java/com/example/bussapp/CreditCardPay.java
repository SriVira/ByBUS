package com.example.bussapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bussapp.Class.CreditCrdPay;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreditCardPay extends AppCompatActivity {

    EditText CrdHoldName, CrdNo, cvc, ExpDate;

    Button btnCrdPay;
    DatabaseReference DBRef;
    CreditCrdPay crdPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card_pay);

        CrdHoldName = findViewById(R.id.CrdHoldName);
        CrdNo = findViewById(R.id.CrdNo);
        cvc = findViewById(R.id.cvc);
        ExpDate = findViewById(R.id.ExpDate);
        btnCrdPay=findViewById(R.id.btnCrdPay);
        crdPay = new CreditCrdPay();


        DBRef = FirebaseDatabase.getInstance().getReference().child("CreditCardDetails");
        DBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnCrdPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(CrdHoldName.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter Card Holder Name", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(CrdNo.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please Enter Card Number", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(cvc.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please Enter CVC", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(ExpDate.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please Enter Expire Date", Toast.LENGTH_SHORT).show();
                else {
                    crdPay.setCrdHName(CrdHoldName.getText().toString().trim());
                    crdPay.setCrdNo(Integer.parseInt(CrdNo.getText().toString().trim()));
                    crdPay.setCVC(Integer.parseInt(cvc.getText().toString().trim()));
                    crdPay.setExpDate(ExpDate.getText().toString().trim());

                    DBRef.child(CrdHoldName.getText().toString()).setValue(crdPay);

                    Toast.makeText(CreditCardPay.this, "Successfully paid", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
    }


