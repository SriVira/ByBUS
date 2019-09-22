package com.example.bussapp.AdminRoute;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bussapp.R;

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
    public void onBindViewHolder(@NonNull final RouteViewHolder holder, int position) {

        RouteDetails routeDetails =routeDetailsList.get(position);

        holder.Rnumber.setText(String.valueOf(routeDetails.getRNumber()));
        holder.StartTime.setText(routeDetails.getStartTime());
        holder.EndTime.setText(routeDetails.getEndTime());
        holder.From.setText(routeDetails.getFrom());
        holder.To.setText(routeDetails.getTO());

        holder.list_item_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, activity_admin_updel_route_details.class);
                intent.putExtra("RouteNumber",holder.Rnumber.getText());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return routeDetailsList.size();
    }

    class RouteViewHolder extends RecyclerView.ViewHolder {

        TextView Rnumber,StartTime,EndTime,From,To;
        RelativeLayout list_item_layout;

        public RouteViewHolder(@NonNull View itemView) {
            super(itemView);

            Rnumber =itemView.findViewById(R.id.rnumbertxt);
            StartTime =itemView.findViewById(R.id.stimetxt);
            EndTime =itemView.findViewById(R.id.etimetxt);
            From =itemView.findViewById(R.id.fromtxt);
            To =itemView.findViewById(R.id.totxt);
            list_item_layout =itemView.findViewById(R.id.list_item_layout);
        }
    }


}
