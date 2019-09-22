package com.example.bussapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bussapp.AdminPayments.AddPayment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Admin_Add_Payment extends AppCompatActivity {

    EditText Cname, Cno, Cvc, Exp;
    Button addBtn;
    DatabaseReference DBRef;
    AddPayment addPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__add__payment);

        Cname = findViewById(R.id.addCName);
        Cno = findViewById(R.id.addCNo);
        Cvc = findViewById(R.id.addCvc);
        Exp = findViewById(R.id.addExp);
        addBtn = findViewById(R.id.addBtn);

        addPayment = new AddPayment();

        DBRef = FirebaseDatabase.getInstance().getReference().child("CreditCardDetails");
        DBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    addPayment.setCname(Cname.getText().toString().trim());
                    addPayment.setCno(Integer.parseInt(Cno.getText().toString().trim()));
                    addPayment.setCvc(Integer.parseInt(Cvc.getText().toString().trim()));
                    addPayment.setExp(Exp.getText().toString().trim());

                    DBRef.child(Cname.getText().toString()).setValue(addPayment);
                    Toast.makeText(Admin_Add_Payment.this,"Success",Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(Admin_Add_Payment.this,e.getMessage().toString(),Toast.LENGTH_LONG).show();
                }

            }
        });

    }



}
