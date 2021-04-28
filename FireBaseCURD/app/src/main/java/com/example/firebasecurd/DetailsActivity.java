package com.example.firebasecurd;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    RecyclerView rv;
    FirebaseDatabase database;
    DatabaseReference reference;
    ArrayList<User> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        rv = findViewById(R.id.recycle);
        rv.setLayoutManager(new LinearLayoutManager(this));

        database = FirebaseDatabase.getInstance();
        reference=database.getReference();
        //Toast.makeText(this, ""+getIntent().getStringExtra("data"), Toast.LENGTH_SHORT).show();

       /* reference.child("contacts").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                    User user = singleSnapshot.getValue(User.class);
                    list.add(user);
                }
                Toast.makeText(DetailsActivity.this, ""+list.size(), Toast.LENGTH_SHORT).show();
                rv.setAdapter(new MyAdapter(DetailsActivity.this,list));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });*/
        reference.child("contacts").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                    User user = singleSnapshot.getValue(User.class);
                    list.add(user);
                }
                Toast.makeText(DetailsActivity.this, ""+list.size(), Toast.LENGTH_SHORT).show();
                rv.setAdapter(new MyAdapter(list,DetailsActivity.this));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add){
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }
        return true;
    }
}