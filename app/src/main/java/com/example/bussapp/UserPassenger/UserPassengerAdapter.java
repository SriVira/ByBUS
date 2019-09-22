package com.example.bussapp.UserPassenger;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bussapp.AdminRoute.RouteAdapter;
import com.example.bussapp.AdminRoute.RouteDetails;
import com.example.bussapp.R;
import com.example.bussapp.SelectSeat;

import java.util.List;

public class UserPassengerAdapter extends RecyclerView.Adapter<UserPassengerAdapter.PassengerRouteViewHolder>{

    private Context context;
    private List<RouteDetails> routeDetailsList;

    public UserPassengerAdapter(Context context, List<RouteDetails> routeDetailsList) {
        this.context = context;
        this.routeDetailsList = routeDetailsList;
    }

    @NonNull
    @Override
    public PassengerRouteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.passenger_root_list_layout,null);
        return new PassengerRouteViewHolder(view);

    }
    @Override
    public void onBindViewHolder(@NonNull final PassengerRouteViewHolder holder, int position) {

        RouteDetails routeDetails = routeDetailsList.get(position);
        holder.Passenger_crdv_routeNo.setText(String.valueOf(routeDetails.getRNumber()));
        holder.Passenger_crdv_stime.setText(routeDetails.getStartTime());
        holder.Passenger_crdv_arrtime.setText(routeDetails.getEndTime());
        holder.Passenger_crdv_from.setText(routeDetails.getFrom());
        holder.Passenger_crdv_to.setText(routeDetails.getTO());

        holder.Passenger_relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(context, SelectSeat.class);
                intent1.putExtra("RouteNo",holder.Passenger_crdv_routeNo.getText());
                context.startActivity(intent1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return routeDetailsList.size();
    }

    class PassengerRouteViewHolder extends RecyclerView.ViewHolder{

        TextView Passenger_crdv_routeNo,Passenger_crdv_stime,Passenger_crdv_arrtime,Passenger_crdv_from,Passenger_crdv_to;
        RelativeLayout Passenger_relativeLayout;

        public PassengerRouteViewHolder(@NonNull View itemView) {
            super(itemView);
            Passenger_crdv_routeNo=itemView.findViewById(R.id.Passenger_crdv_routeNo);
            Passenger_crdv_stime = itemView.findViewById(R.id.Passenger_crdv_stime);
            Passenger_crdv_arrtime=itemView.findViewById(R.id.Passenger_crdv_arrtime);
            Passenger_crdv_from = itemView.findViewById(R.id.Passenger_crdv_from);
            Passenger_crdv_to = itemView.findViewById(R.id.Passenger_crdv_to);
            Passenger_relativeLayout = itemView.findViewById(R.id.Passenger_relativeLayout);


        }
    }

















}
