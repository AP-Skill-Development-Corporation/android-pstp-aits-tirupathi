package com.example.prohelpr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Worker_Booking_data extends RecyclerView.Adapter<Worker_Booking_data.Myviewadapter> {

    Context ct;
    String[] s;
    public Worker_Booking_data(Context workerBookingFragment, String[] data) {
        ct = workerBookingFragment;
        s = data;
    }
    @NonNull
    @Override
    public Myviewadapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Worker_Booking_data.Myviewadapter(LayoutInflater.from(ct).inflate(R.layout.worker_booking_row_design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewadapter holder, int position) {
        holder.tv.setText(s[position]);
    }

    @Override
    public int getItemCount() {
        return s.length;
    }

    public class Myviewadapter extends RecyclerView.ViewHolder {
        TextView tv;
        public Myviewadapter(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.name);
        }
    }
}
