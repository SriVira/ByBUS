package com.example.bussapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;

public class admin_drivers extends AppCompatActivity {


    private static  final  String TAG ="admin_drivers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_drivers);

        AdminDriversList();

    }

    public void AdminDriversList(){
        SwipeMenuListView driverslistview = (SwipeMenuListView) findViewById(R.id.driverslist);
        ArrayList<String> list = new ArrayList<>();

        list.add("Driver_1");
        list.add("Driver_2");
        list.add("Driver_3");

        ArrayAdapter booklistArad =  new ArrayAdapter(admin_drivers.this,android.R.layout.simple_list_item_1,list);
        driverslistview.setAdapter(booklistArad);

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

        driverslistview.setMenuCreator(creator);

        driverslistview.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
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



    }



}
