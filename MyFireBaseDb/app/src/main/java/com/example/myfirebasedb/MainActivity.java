package com.example.myfirebasedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText et_username,et_aadhar,et_email,et_mobile;
FirebaseDatabase database;
DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_username=findViewById(R.id.editText_username);
        et_aadhar=findViewById(R.id.editText_aadhar);
        et_mobile=findViewById(R.id.editText_Mobile);
        et_email=findViewById(R.id.editText_email);
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("UsersDataBase");


    }

    public void saveDataToFirebase(View view) {
        String name=et_username.getText().toString();
        String aadhar=et_aadhar.getText().toString();
        String mobile=et_mobile.getText().toString();
        String email=et_email.getText().toString();
        UsersPojoModel pojoModel=new UsersPojoModel(name,aadhar,email,mobile);
        reference.push().setValue(pojoModel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void retriveDb(View view) {
        Intent intent=new Intent(this,DisplayActivity.class);
        startActivity(intent);
    }
}