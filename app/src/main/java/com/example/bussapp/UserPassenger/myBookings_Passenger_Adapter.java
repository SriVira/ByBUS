package com.example.bussapp.UserPassenger;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

import com.example.bussapp.Class.BookSeat;
import com.example.bussapp.MyBookings;
import com.example.bussapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class myBookings_Passenger_Adapter extends RecyclerView.Adapter<myBookings_Passenger_Adapter.myb_routeViewHolder>{

    private Context context;
    private List<BookSeat>bookSeatList;
    DatabaseReference reference;
    myBookings_Passenger_Adapter myBookings_passenger_adapter;
    MyBookings myBookings;

    public myBookings_Passenger_Adapter(Context context,List<BookSeat>bookSeatList){
        this.context=context;
        this.bookSeatList=bookSeatList;
    }



    @NonNull
    @Override
    public myb_routeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.passenger_mybookings_layout,null);
        return new myb_routeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myb_routeViewHolder holder, int position) {

        BookSeat bookSeat =bookSeatList.get(position);
        holder.myb_routeNo.setText(String.valueOf(bookSeat.getTxtrouteNo()));
        holder.myb_seatNo.setText(String.valueOf(bookSeat.getSeatNo()));
        holder.myb_busNo.setText(bookSeat.getTxtSBusNo());
        holder.myb_dName.setText(bookSeat.getTxtSDName());
        holder.myb_conNo.setText(bookSeat.getTxtSConNo());
        holder.myb_from.setText(bookSeat.getTxtSfrom());
        holder.myb_to.setText(bookSeat.getTxtSto());
        holder.myb_dTime.setText(bookSeat.getTxtSDTime());
        holder.myb_arTime.setText(bookSeat.getTxtSArTime());
        holder.myb_date.setText(bookSeat.getTxtDate());
        holder.myb_pay.setText(bookSeat.getTxtPay());

        holder.myb_btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               try {

                   //notifyDataSetChanged();
                   AlertDialog.Builder deleteokalertbox = new AlertDialog.Builder(context);
                   deleteokalertbox.setMessage("Do You Want To Delete ?");
                   deleteokalertbox.setCancelable(true);
                   deleteokalertbox.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {

                           context.startActivity(new Intent(context,MyBookings.class));
                           reference = FirebaseDatabase.getInstance().getReference().child("BookSeat").child(holder.myb_seatNo.getText().toString());
                           reference.removeValue();
                       }
                   });

                   deleteokalertbox.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                         dialogInterface.cancel();
                       }
                   });

                   AlertDialog alertDialog = deleteokalertbox.create();
                   //alertDialog.setTitle("");
                   alertDialog.show();;
                    //Toast.makeText(context, "Details Deleted Successfully", Toast.LENGTH_LONG).show();


                } catch (Exception e) {
                    Toast.makeText(context, "No Source to Delete", Toast.LENGTH_LONG).show();

                }

            }
        });

    }
    @Override
    public int getItemCount() {
        return bookSeatList.size();
    }


    class myb_routeViewHolder extends RecyclerView.ViewHolder {

    TextView myb_routeNo, myb_busNo, myb_dName, myb_conNo, myb_seatNo, myb_from, myb_to, myb_dTime, myb_arTime, myb_date, myb_pay;
    RelativeLayout myb_relativeLayout;
    Button myb_btn_delete;

    public myb_routeViewHolder(@NonNull View itemView) {
        super(itemView);
        myb_routeNo = itemView.findViewById(R.id.myb_routeNo);
        myb_busNo = itemView.findViewById(R.id.myb_busNo);
        myb_dName = itemView.findViewById(R.id.myb_dName);
        myb_conNo = itemView.findViewById(R.id.myb_conNo);
        myb_seatNo = itemView.findViewById(R.id.myb_seatNo);
        myb_from = itemView.findViewById(R.id.myb_from);
        myb_to = itemView.findViewById(R.id.myb_to);
        myb_dTime = itemView.findViewById(R.id.myb_dTime);
        myb_arTime = itemView.findViewById(R.id.myb_arTime);
        myb_date = itemView.findViewById(R.id.myb_date);
        myb_pay = itemView.findViewById(R.id.myb_pay);
        myb_relativeLayout = itemView.findViewById(R.id.myb_relativeLayout);
        myb_btn_delete = itemView.findViewById(R.id.myb_btn_delete);

    }


}

}