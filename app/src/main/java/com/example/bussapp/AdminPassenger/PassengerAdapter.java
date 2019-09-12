package com.example.bussapp.AdminPassenger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bussapp.Class.Register;
import com.example.bussapp.R;

import java.util.List;

public class PassengerAdapter extends RecyclerView.Adapter<PassengerAdapter.PassengerViewHolder> {

    private Context context;
    private List<Register> registerList;

    public PassengerAdapter(Context context, List<Register> registerList) {
        this.context = context;
        this.registerList = registerList;
    }

    @NonNull
    @Override
    public PassengerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater =LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.admin_passenger_list_layout,null);

        return new PassengerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PassengerViewHolder holder, int position) {

        Register register = registerList.get(position);

        holder.Pname.setText(register.getName());
        holder.Pcontact.setText(register.getConNo());


    }


    @Override
    public int getItemCount() {
        return registerList.size();
    }

    class PassengerViewHolder extends  RecyclerView.ViewHolder{

        TextView Pname,Pcontact;
        RelativeLayout relativeLayout;


        public PassengerViewHolder(@NonNull View itemView) {
            super(itemView);

            Pname =itemView.findViewById(R.id.passenger_nametxt);
            Pcontact =itemView.findViewById(R.id.passenger_contacttxt);
            relativeLayout =itemView.findViewById(R.id.passenger_cardview_layout);



        }
    }

}
