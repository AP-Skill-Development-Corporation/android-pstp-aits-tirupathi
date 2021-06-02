package com.example.myfirebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    Context ct;
    List<StudentPojoModel> pojoModels;

    public StudentAdapter(Context ct, List<StudentPojoModel> pojoModels) {
        this.ct = ct;
        this.pojoModels = pojoModels;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentViewHolder(LayoutInflater.from(ct).inflate(R.layout.designrow, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.branch.setText(pojoModels.get(position).getBranch());
        holder.name.setText(pojoModels.get(position).getName());
        holder.mobile.setText(pojoModels.get(position).getMobile());
        holder.address.setText(pojoModels.get(position).getAddress());
        holder.gender.setText(pojoModels.get(position).getGender());
        holder.mail.setText(pojoModels.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return pojoModels.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView name, mail, address, mobile, gender, branch;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView_name);
            mail = itemView.findViewById(R.id.textViewEmail);
            address = itemView.findViewById(R.id.textViewAddress);
            mobile = itemView.findViewById(R.id.textViewMobile);
            gender = itemView.findViewById(R.id.textViewGender);
            branch = itemView.findViewById(R.id.textViewBranch);
        }
    }
}
