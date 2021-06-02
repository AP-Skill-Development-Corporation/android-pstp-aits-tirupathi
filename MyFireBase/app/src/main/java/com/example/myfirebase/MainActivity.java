package com.example.myfirebase;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rec;
    EditText sname, smail, saddress, smobile;
    Spinner branchsSpiner;
    RadioButton male, female;
    String gender;
    FirebaseDatabase database;
    DatabaseReference reference;
    StudentAdapter adapter;
    List<StudentPojoModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*connect all id's here*/
        rec = findViewById(R.id.recycler);
        sname = findViewById(R.id.et_stuName);
        smail = findViewById(R.id.et_stuMail);
        saddress = findViewById(R.id.et_stuAddres);
        smobile = findViewById(R.id.et_mobile);
        branchsSpiner = findViewById(R.id.spiner_branch);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Students");


    }

    public void saveData(View view) {
        String name = sname.getText().toString();
        String email = smail.getText().toString();
        String address = saddress.getText().toString();
        String mobile = smobile.getText().toString();
        String branch = branchsSpiner.getSelectedItem().toString();
        if (male.isChecked()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        if (name.isEmpty() || email.isEmpty() || address.isEmpty() || mobile.isEmpty()) {
            Snackbar.make(view, "not empty above fields", Snackbar.LENGTH_LONG).show();

        } else {
            if (branch.equals("select branch")) {
                Toast.makeText(this, "please Select Branch", Toast.LENGTH_SHORT).show();

            } else {
                StudentPojoModel pojoModel = new StudentPojoModel(name, email, mobile, address, gender, branch);
                reference.push().setValue(pojoModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        }
    }

    public void retriveData(View view) {
        list=new ArrayList<>();
        reference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds:snapshot.getChildren()){
                    StudentPojoModel emp=ds.getValue(StudentPojoModel.class);
                    list.add(emp);
                }

                adapter = new StudentAdapter(getApplicationContext(), list);
                rec.setAdapter(adapter);
                rec.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                Toast.makeText(MainActivity.this, "" + list.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        });

       /* list=new ArrayList<>();
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren()){
                    StudentPojoModel model=ds.getValue(StudentPojoModel.class);
                    list.add(model);
                }
                Toast.makeText(MainActivity.this, "total "+list.size(), Toast.LENGTH_SHORT).show();
                   adapter=new StudentAdapter(MainActivity.this,list);
                   rec.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                   rec.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
            }
        });
*/
    }
}