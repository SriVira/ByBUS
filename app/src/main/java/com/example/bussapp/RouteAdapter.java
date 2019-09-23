package com.example.bussapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

//import static com.example.bussapp.R.id.linearlayout_Routes;


public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.MyViewHolder> {
    @NonNull
    private static final String TAG = "DriverRecycleViewAdapter";

    private Context context;
    private ArrayList<Driver_RouteDetails> Rlist;



    public RouteAdapter(Context context, ArrayList<Driver_RouteDetails> Rlist) {
        this.context = context;
        this.Rlist = Rlist;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v =LayoutInflater.from(context).inflate(R.layout.layout_routelist,parent,false);
       MyViewHolder mvh = new MyViewHolder(v);
       return mvh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
      final Driver_RouteDetails routes = Rlist.get(position);
        holder.from.setText(routes.getFrom());
        holder.to.setText(routes.getTo());
        holder.etime.setText(routes.getEndTime());
        holder.stime.setText(routes.getStartTime());
        holder.rno.setText(routes.getRNumber());



       holder.Delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView rno;
                MyViewHolder mvh= new MyViewHolder(view);
                rno =  mvh.itemView.findViewById(R.id.RouteToRV1);
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Driver_Route_Data").child(routes.getID());
                ref.removeValue();

                Toast.makeText(context,"Deleted Successful",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,My_route.class );

                context.startActivity(intent);

            }
        });
        holder.Update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Update.class);
                intent.putExtra("RouteNo",holder.rno.getText());
                intent.putExtra("stime",holder.stime.getText());
                intent.putExtra("etime",holder.etime.getText());
                intent.putExtra("to",holder.to.getText());
                intent.putExtra("from",holder.from.getText());
                intent.putExtra("ID",routes.getID());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Rlist.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView from,to ,rno,etime,stime;
        RelativeLayout Driver_Route_Layout;
        Button Update_btn,Delete_btn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            to =  itemView.findViewById(R.id.RouteToRV1);
            rno =  itemView.findViewById(R.id.RouteNoRV1);
            etime = itemView.findViewById(R.id.RouteETimeRV1);
            stime =  itemView.findViewById(R.id.RouteSTimeRV1);
            from = itemView.findViewById(R.id.RouteFromRV1);

            Driver_Route_Layout = itemView.findViewById(R.id.Driver_Route_Layout);
            Update_btn = itemView.findViewById(R.id.RouteUpdateRV1);
            Delete_btn = itemView.findViewById(R.id.RouteDeleteRV1);
        }
    }


    }





