package com.example.bussapp;

import androidx.appcompat.app.ActionBar;
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

public class admin_bookings extends AppCompatActivity {

    private static  final  String TAG ="admin_bookings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_bookings);


        AdminBookingList();
        admin_bookings_showico();
    }

    public void admin_bookings_showico () {

        ActionBar admin_bookings =getSupportActionBar();
        admin_bookings.setDisplayShowHomeEnabled(true);
        admin_bookings.setIcon(R.mipmap.admin_bookings_icon);


    }

    public void AdminBookingList(){
        SwipeMenuListView  booklistview = (SwipeMenuListView) findViewById(R.id.bookinglist);
        ArrayList<String> booklist = new ArrayList<>();

        booklist.add("Booking1");
        booklist.add("Booking2");
        booklist.add("Booking3");

        ArrayAdapter booklistArad =  new ArrayAdapter(admin_bookings.this,android.R.layout.simple_list_item_1,booklist);
        booklistview.setAdapter(booklistArad);

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

        booklistview.setMenuCreator(creator);

        booklistview.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
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
