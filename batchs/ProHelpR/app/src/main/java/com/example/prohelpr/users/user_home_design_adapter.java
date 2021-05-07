package com.example.prohelpr.users;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prohelpr.R;
import com.example.prohelpr.models.Worker;

import java.util.List;

public class user_home_design_adapter extends RecyclerView.Adapter<user_home_design_adapter.MyViewHolder> {
    Context context;
    List<Worker> list;

    public user_home_design_adapter(Context context, List<Worker> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.fragment_user_home_design, parent, false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//User_home_design li= list.get(position);
        holder.name.setText(list.get(position).getName());
        holder.role.setText(list.get(position).getRole());
        holder.mobileno.setText(list.get(position).getNumber());
        holder.address.setText(list.get(position).getAddress());
        holder.place.setText(list.get(position).getPlace());
        holder.category.setText(list.get(position).getCategory());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, role, mobileno, address, place, category;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.d_name);
            role = itemView.findViewById(R.id.d_role);
            mobileno = itemView.findViewById(R.id.d_mobile);
            address = itemView.findViewById(R.id.d_address);
            place = itemView.findViewById(R.id.d_place);
            category = itemView.findViewById(R.id.d_category);
        }
    }
}
