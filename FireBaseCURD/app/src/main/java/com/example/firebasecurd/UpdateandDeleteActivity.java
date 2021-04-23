package com.example.firebasecurd;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateandDeleteActivity extends AppCompatActivity {

    DatabaseReference reference;
    EditText et_username;
    String userKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateand_delete);
        et_username = findViewById(R.id.u);
        reference = FirebaseDatabase.getInstance().getReference("Users");
    }

    public void get(View view) {
        final String username = et_username.getText().toString();
        final List<User> list = new ArrayList<>();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    User u = snapshot.getValue(User.class);
                    if(u.getUsername().equals(username)){
                        Log.d("Key",snapshot.getKey());
                        userKey = snapshot.getKey();
                        u.setEmail("Hello@gmail.com");
                        u.setName("Hello");
                        u.setUsername("hello");
                        u.setPassword("1234567890");
                        u.setUsername("Mastan");
                        reference.child(userKey).setValue(u);
                        //reference.child(userKey).removeValue();
                        break;
                    }
                    list.add(u);

                }
                /*for(int i = 0; i<list.size();i++){
                    if(username.equals(list.get(i).getUsername())){
                        Log.d("Details",list.get(i).getName()+" "+list.get(i).getPassword());
                        DatabaseReference ref = reference.child(userKey);
                       *//* User u = new User();
                        u.setName("LOKESH");
                        u.setMobileno("123456789099");
                        u.setEmail("lokesh@ding");
                        u.setPassword("Lokesh12345");
                        u.setUsername("Lokesh");*//*
                        ref.child(userKey).child("mobileno").setValue("37197921486");
                        break;
                    }
                }*/

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
  }