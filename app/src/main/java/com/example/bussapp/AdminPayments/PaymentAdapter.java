package com.example.bussapp.AdminPayments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bussapp.R;

import java.util.List;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder> {

    private Context context;
    private List<CreditCrdPay>  creditCrdPayList;

    public PaymentAdapter(Context context, List<CreditCrdPay> creditCrdPayList) {
        this.context = context;
        this.creditCrdPayList = creditCrdPayList;
    }

    @NonNull
    @Override
    public PaymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.activity_admin_payments_list_layout, null);
        return new PaymentViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final PaymentViewHolder holder, int position) {

        CreditCrdPay creditCrdPay = creditCrdPayList.get(position);

        holder.admin_pay_cname.setText(creditCrdPay.getCrdHName());
        holder.admin_pay_cno.setText(creditCrdPay.getCrdNo());
        holder.admin_pay_cvc.setText(creditCrdPay.getCVC());
        holder.admin_pay_exp.setText(creditCrdPay.getExpDate());
    }

    @Override
    public int getItemCount() {
        return creditCrdPayList.size();
    }

    class PaymentViewHolder extends RecyclerView.ViewHolder{

        TextView admin_pay_cname, admin_pay_cno, admin_pay_cvc, admin_pay_exp;
        RelativeLayout relativeLayout;

        public PaymentViewHolder(@NonNull View itemView) {
            super(itemView);

            admin_pay_cname = itemView.findViewById(R.id.admin_pay_cname);
            admin_pay_cno = itemView.findViewById(R.id.admin_pay_cno);
            admin_pay_cvc = itemView.findViewById(R.id.admin_pay_cvc);
            admin_pay_exp = itemView.findViewById(R.id.admin_pay_exp);
            relativeLayout = itemView.findViewById(R.id.admin_pay_relative);
        }
    }
}
