package com.example.firebasedatabaseexample;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    EditText e_name, e_id;
    FirebaseDatabase database;
    DatabaseReference reference;
    List<Employee> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e_name = findViewById(R.id.et_empname);
        e_id = findViewById(R.id.et_empId);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Employees");
    }

    public void loginEvent(View view) {
        String ename = e_name.getText().toString();
        String eid = e_id.getText().toString();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {

                    if (ename.equals(list.get(i).getEname())) {
                        Log.i("Login",list.get(i).getEname());
                        Toast.makeText(LoginActivity.this, "welcome..", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}