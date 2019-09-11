package com.example.bussapp.AdminRoute;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bussapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class admin_routes extends AppCompatActivity {

    private static  final  String TAG ="admin_routes";

    RecyclerView recyclerView;
    RouteAdapter routeAdapter;
    List<RouteDetails> routeDetailsList;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_routes);


        routeDetailsList = new ArrayList<RouteDetails>();
        recyclerView = (RecyclerView) findViewById(R.id.route_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        reference =FirebaseDatabase.getInstance().getReference().child("Routes_Data");



        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    RouteDetails routeDetails =  dataSnapshot1.getValue(RouteDetails.class);
                    routeDetailsList.add(routeDetails);
                    findViewById(R.id.load_routedata_progress).setVisibility(View.GONE);
                }

                routeAdapter = new RouteAdapter(admin_routes.this,routeDetailsList);
                recyclerView.setAdapter(routeAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(admin_routes.this,"No Route Data Found.",Toast.LENGTH_LONG).show();

            }
        });


        //routeAdapter = new RouteAdapter(this,routeDetailsList);


    }
    public void admin_add_route(View V){

        Intent admin_add_route = new Intent(this, com.example.bussapp.AdminRoute.admin_add_route.class);
        startActivity(admin_add_route);
    }

}
