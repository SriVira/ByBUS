package com.example.bussapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
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
        recyclerView.setLayoutManager(new LinearLayoutManager(this));/*
        routeDetailsList.add(new RouteDetails("Mahiyanganaya","Kandy","9.00Am","12.00pm",1));
        routeDetailsList.add(new RouteDetails(" Kandy","Mahiyanganaya","10.00Am","1.00pm",2));*/
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

    /*public void AdminRouteList(){
        SwipeMenuListView routelistview = (SwipeMenuListView) findViewById(R.id.routelist);
        ArrayList<String> list = new ArrayList<>();

        list.add("Route_1");
        list.add("Route_2");
        list.add("Route_3");

        ArrayAdapter booklistArad =  new ArrayAdapter(admin_routes.this,android.R.layout.simple_list_item_1,list);
        routelistview.setAdapter(booklistArad);

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0x8B, 0x00,
                        0x8B)));
                // set item width
                openItem.setWidth(200);
                // set item title
                openItem.setTitle("Update");
                // set item title fontsize
                openItem.setTitleSize(18);

                // set item title font color
                openItem.setTitleColor(Color.rgb(0xff, 0xff,0xff));
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0x00, 0x00, 0x00)));
                // set item width
                deleteItem.setWidth(200);
                // set a icon
                deleteItem.setIcon(R.mipmap.deleteicon);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        routelistview.setMenuCreator(creator);

        routelistview.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        Log.d(TAG,"Clicked :"+index);
                        break;
                    case 1:
                        Log.d(TAG,"Clicked :"+index);
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });



    }*/

    public void admin_add_route(View V){

        Intent admin_add_route = new Intent(this,admin_add_route.class);
        startActivity(admin_add_route);
    }

}
