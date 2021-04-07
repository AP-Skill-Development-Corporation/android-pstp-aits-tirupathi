package com.example.retrofitexample;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecyclerDateAdapter extends
        RecyclerView.Adapter<RecyclerDateAdapter.DateViewHolder> {
    Context ctx;
    List<Repo> list;

    public RecyclerDateAdapter(Context ctx, List<Repo> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @NonNull
    @Override
    public DateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DateViewHolder(LayoutInflater.from(ctx).inflate(R.layout.mylayout,
                parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DateViewHolder holder, int position) {
        String finalDate=list.get(position).getDate();
        holder.date.setText(properDateFormat(finalDate));
        holder.date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            String act= String.valueOf(list.get(position).getActive());
            String recovr= String.valueOf(list.get(position).getRecovered());
            String cnf= String.valueOf(list.get(position).getConfirmed());
            String countr= String.valueOf(list.get(position).getCountry());
            String deat= String.valueOf(list.get(position).getDeaths());
            String date= String.valueOf(list.get(position).getDate());
                /*Toast.makeText(ctx, "you clicked"+
                        holder.date.getText().toString(), Toast.LENGTH_SHORT).show();*/
                Toast.makeText(ctx, "active"+
                        act+"\n"+"Recover:"+recovr, Toast.LENGTH_SHORT).show();
               Intent intent=new Intent(ctx,DetailsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               intent.putExtra("a",act);
                intent.putExtra("re",recovr);
                intent.putExtra("cn",cnf);
                intent.putExtra("cou",countr);
                intent.putExtra("de",deat);
                intent.putExtra("da",properDateFormat(date));

                ctx.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DateViewHolder extends RecyclerView.ViewHolder  {
        TextView date;
        public DateViewHolder(@NonNull View itemView) {
            super(itemView);
                    date = itemView.findViewById(R.id.tv_date);

        }


    }

    private String properDateFormat(String resDate) {
        String inputPattern = "yy-mm-dd";
        String outputPattern = "dd-mm-yy";
        SimpleDateFormat inputDate = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputDate = new SimpleDateFormat(outputPattern);
        Date d = null;
        String str = null;
        try {
            d = inputDate.parse(resDate);
            str = outputDate.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }
}
