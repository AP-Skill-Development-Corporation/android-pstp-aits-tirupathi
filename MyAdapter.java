package com.example.myrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    Context ctx;
    String title[];
    String sub_tit[];
    int postr[];

    public MyAdapter(Context ctx, String[] title, String[] sub_tit, int[] postr) {
        this.ctx = ctx;
        this.title = title;
        this.sub_tit = sub_tit;
        this.postr = postr;
    }
    /*whats is the use of constructors*/
    /*Data passing to one cls to another */


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(ctx).inflate(R.layout.row_design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.t.setText(title[position]);
        holder.st.setText(sub_tit[position]);
        holder.img.setImageResource(postr[position]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView t,st;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t=itemView.findViewById(R.id.tv_title);
            st=itemView.findViewById(R.id.tv_subtitle);
            img=itemView.findViewById(R.id.iv);
        }
    }


}
