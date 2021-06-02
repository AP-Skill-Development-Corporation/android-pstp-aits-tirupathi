package com.example.myfirebasedb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {
RecyclerView recycler;
FirebaseDatabase database;
DatabaseReference reference;
    List<UsersPojoModel> list;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        recycler=findViewById(R.id.rec);
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("UsersDataBase");


    }

    public void retriveData(View view) {

        list=new ArrayList<>();
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot ds:snapshot.getChildren()) {
                    UsersPojoModel pojoModel=ds.getValue(UsersPojoModel.class);
                    list.add(pojoModel);
                }
                Toast.makeText(DisplayActivity.this, ""+list.size(), Toast.LENGTH_SHORT).show();
                adapter=new MyAdapter(DisplayActivity.this,list);
                recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}