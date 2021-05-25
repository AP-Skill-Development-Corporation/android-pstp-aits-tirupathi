package com.example.d_learn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MultipleVideosActivity extends AppCompatActivity {
RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_videos);
        rv=findViewById(R.id.recycler);
        String links[] = {"3QNW3guTYU8","bquL4KqZBA4","hWButXKPZPQ","x6Q7c9RyMzk","FmjJ-e5uGuY","DfMq3La8i84"};
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MultiVideosAdapter(this,links));
    }
}