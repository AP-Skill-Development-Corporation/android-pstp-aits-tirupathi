package com.example.registrationwithfirbasedatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context ctx;
    List<studentPojo> list;

    public MyAdapter(Context ctx, List<studentPojo> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(ctx).inflate(R.layout.row, parent, false));

    }

    /*9618998146*/
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_email.setText(list.get(position).getEmail());
        holder.tv_mobile.setText(list.get(position).getMobilenumbr());
        holder.tv_name.setText(list.get(position).getName());
        holder.tv_branch.setText(list.get(position).getBranch());
        holder.tv_rollnumber.setText(list.get(position).getRollNumber());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_rollnumber, tv_mobile, tv_email, tv_branch;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_branch = itemView.findViewById(R.id.textView_branch);
            tv_name = itemView.findViewById(R.id.textView_name);
            tv_rollnumber = itemView.findViewById(R.id.textView_rollnumber);
            tv_mobile = itemView.findViewById(R.id.textView_mobile);
            tv_email = itemView.findViewById(R.id.textView_email);
        }
    }
}
