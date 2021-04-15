package com.example.roomdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHoder> {

    Context ct;
    List<Student> list;

    public DataAdapter(MainActivity mainActivity, List<Student> studentList) {
        ct = mainActivity;
        list = studentList;
    }

    @NonNull
    @Override
    public DataAdapter.DataViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct).inflate(R.layout.rowdesign,
                                                        parent,false);
        return new DataViewHoder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.DataViewHoder holder, int position) {

        Student student = list.get(position);
        holder.name.setText(student.getName());
        holder.rollnumber.setText(student.getRollNumber());
        holder.phone.setText(student.getPhoneNumber());
        holder.mail.setText(student.getMailID());
        holder.gender.setText(student.getGender());
        holder.language.setText(student.getLanguage());
        holder.department.setText(student.getDepartment());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MainActivity.dataBase.myDao().deleteStudent(student);

                MainActivity.viewModel.delete(student);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DataViewHoder extends RecyclerView.ViewHolder{

        TextView name,mail,phone,rollnumber,gender,language,department;
        ImageView update,delete;

        public DataViewHoder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.rname);
            mail = itemView.findViewById(R.id.rmail);
            phone = itemView.findViewById(R.id.rphone);
            rollnumber = itemView.findViewById(R.id.rrollNumber);
            gender = itemView.findViewById(R.id.rgender);
            language = itemView.findViewById(R.id.rlanguage);
            department = itemView.findViewById(R.id.rdepeartment);
            update = itemView.findViewById(R.id.update);
            delete = itemView.findViewById(R.id.delete);

        }
    }
}
