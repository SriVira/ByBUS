package com.example.bussapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class BookingAdpter_Driver extends RecyclerView.Adapter<BookingAdpter_Driver.MyViewHolder>  {

    private Context context;
    private ArrayList<Booking_details> Blist;

    public BookingAdpter_Driver(Context context, ArrayList<Booking_details> blist) {
        this.context = context;
        Blist = blist;
    }

    @NonNull
    @Override
    public BookingAdpter_Driver.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v =LayoutInflater.from(context).inflate(R.layout.layout_booking_list,null);
        BookingAdpter_Driver.MyViewHolder mvh = new BookingAdpter_Driver.MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull BookingAdpter_Driver.MyViewHolder holder, int position) {
        final Booking_details bookings = Blist.get(position);
        holder.seatNo.setText(String.valueOf(bookings.getSeatNo()));
    }

    @Override
    public int getItemCount() {
        return Blist.size();
    }


    class  MyViewHolder extends  RecyclerView.ViewHolder{
        TextView seatNo;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            RelativeLayout Driver_Route_Layout;

             seatNo =  itemView.findViewById(R.id.SeateNoCV);

             Driver_Route_Layout = itemView.findViewById(R.id.Booking_list_RV);

        }
    }
    }


