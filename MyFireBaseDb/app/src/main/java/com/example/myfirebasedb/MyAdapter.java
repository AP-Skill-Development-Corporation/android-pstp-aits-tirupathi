package com.example.myfirebasedb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    DisplayActivity ctx;
    List<UsersPojoModel> pojoModels;

    public MyAdapter(DisplayActivity ctx, List<UsersPojoModel> pojoModels) {
        this.ctx = ctx;
        this.pojoModels = pojoModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(ctx).inflate(R.layout.every_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
holder.tv_mobile.setText(pojoModels.get(position).getMobile());
holder.tv_emil.setText(pojoModels.get(position).getEmail());
holder.tv_name.setText(pojoModels.get(position).getName());
holder.tv_aadhar.setText(pojoModels.get(position).getAadhar());
    }

    @Override
    public int getItemCount() {
        return pojoModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name,tv_aadhar,tv_emil,tv_mobile;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_aadhar=itemView.findViewById(R.id.textView_aadhar);
            tv_name=itemView.findViewById(R.id.textView_name);
            tv_emil=itemView.findViewById(R.id.textView_email);
            tv_mobile=itemView.findViewById(R.id.textView_mobile);
        }
    }
}
