package com.example.firebasecurd;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    EditText et_username,et_password;
    FirebaseDatabase database;
    DatabaseReference reference;
    List<User> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_username = findViewById(R.id.loginusername);
        et_password = findViewById(R.id.loginpassword);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Users");
        list = new ArrayList<>();
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    User u = snapshot.getValue(User.class);
                    list.add(u);

                }
                Toast.makeText(LoginActivity.this,
                        ""+list.size(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    public void login(View view) {
        final String username = et_username.getText().toString();
        final String password = et_password.getText().toString();
        for(int i = 0;i<list.size();i++){
            if((username.equals(list.get(i).getUsername()))&&
                    (password.equals(list.get(i).getPassword()))){
                startActivity(new Intent(this,WelcomeActivity.class));
                Toast.makeText(this, "Sucess", Toast.LENGTH_SHORT).show();
                break;
            }else{
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();

            }

        }
    }

    public void newUser(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}