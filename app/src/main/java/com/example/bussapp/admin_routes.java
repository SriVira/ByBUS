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

public class admin_routes extends AppCompatActivity {

    private static  final  String TAG ="admin_routes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_routes);

        AdminRouteList();

    }

    public void AdminRouteList(){
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



    }
}
