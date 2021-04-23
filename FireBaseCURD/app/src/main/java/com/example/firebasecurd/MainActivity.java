package com.example.firebasecurd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_name,et_mobile,et_email,et_username,et_password;
    Button b_save;
    TextView tv;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectivityManager conMgr =  (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        if (netInfo == null){
            //EventLogTags.Description.setVisibility(View.INVISIBLE);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle(getResources().getString(R.string.app_name))
                    .setMessage("Please Check your Internetconnection")
                    .setPositiveButton("OK", null).show();
        }else {
            Toast.makeText(this,
                    "Iternet is Available", Toast.LENGTH_SHORT).show();
        }

        et_name = findViewById(R.id.name);
        et_mobile = findViewById(R.id.mobileno);
        et_email = findViewById(R.id.email);
        et_username = findViewById(R.id.username);
        et_password = findViewById(R.id.password);
        b_save = findViewById(R.id.savebutton);
        tv = findViewById(R.id.datatextview);
        b_save.setOnClickListener(this);
        database= FirebaseDatabase.getInstance();
        reference = database.getReference("Users");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.savebutton:
                saveData();
                break;
        }
    }

    private void saveData() {
        final List<User> list = new ArrayList<>();
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        String name = et_name.getText().toString();
        String mobile = et_mobile.getText().toString();
        String email = et_email.getText().toString();
        final String username = et_username.getText().toString();
        String password = et_password.getText().toString();

        User u = new User(name,mobile,email,username,password);
        reference.push().setValue(u).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this,
                        "Details Saved Successfully...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("Mastan",e.getMessage());
            }
        });

       /* reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    User u = snapshot.getValue(User.class);
                    tv.append(u.getName());
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });*/


    }

    public void update(View view) {
        startActivity(new Intent(this,UpdateandDeleteActivity.class));
    }
}