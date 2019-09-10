package com.example.bussapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.RouteViewHolder> {

    private Context context;
    private List<RouteDetails> routeDetailsList;

    public RouteAdapter(Context context, List<RouteDetails> routeDetailsList) {
        this.context = context;
        this.routeDetailsList = routeDetailsList;
    }

    @NonNull
    @Override
    public RouteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.admin_route_list_layout,null);
        return new RouteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RouteViewHolder holder, int position) {

        RouteDetails routeDetails =routeDetailsList.get(position);

        holder.Rnumber.setText(String.valueOf(routeDetails.getRNumber()));
        holder.StartTime.setText(routeDetails.getStartTime());
        holder.EndTime.setText(routeDetails.getEndTime());
        holder.From.setText(routeDetails.getFrom());
        holder.To.setText(routeDetails.getTO());

    }

    @Override
    public int getItemCount() {
        return routeDetailsList.size();
    }

    class RouteViewHolder extends RecyclerView.ViewHolder {

        TextView Rnumber,StartTime,EndTime,From,To;


        public RouteViewHolder(@NonNull View itemView) {
            super(itemView);

            Rnumber =itemView.findViewById(R.id.rnumbertxt);
            StartTime =itemView.findViewById(R.id.stimetxt);
            EndTime =itemView.findViewById(R.id.etimetxt);
            From =itemView.findViewById(R.id.fromtxt);
            To =itemView.findViewById(R.id.totxt);
        }
    }


}
