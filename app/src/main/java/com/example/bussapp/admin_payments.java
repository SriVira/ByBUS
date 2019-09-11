package com.example.bussapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.example.bussapp.AdminPayments.PaymentAdapter;
import com.example.bussapp.Class.CreditCrdPay;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class admin_payments extends AppCompatActivity {

    private static  final  String TAG ="admin_payments";

    RecyclerView recyclerView;
    PaymentAdapter paymentAdapter;
    List<CreditCrdPay> creditCrdPayList;
    DatabaseReference DBRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_payments);

        creditCrdPayList = new ArrayList<CreditCrdPay>();
        recyclerView = findViewById(R.id.admin_pay_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        DBRef = FirebaseDatabase.getInstance().getReference("CreditCardDetails");
        DBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    CreditCrdPay creditCrdPay = dataSnapshot1.getValue(CreditCrdPay.class);
                    creditCrdPayList.add(creditCrdPay);
                }

                paymentAdapter = new PaymentAdapter(admin_payments.this,creditCrdPayList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
