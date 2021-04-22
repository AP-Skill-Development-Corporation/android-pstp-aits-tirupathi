package com.example.registrationwithfirbasedatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText et_name,et_rollnumber,et_mail,et_mobile,et_branch;
String t_name,t_rollnumber,t_mail,t_mobile,t_branch;
List<studentPojo> list;
studentPojo pojo;
FirebaseDatabase database;
DatabaseReference reference;
MyAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        database=FirebaseDatabase.getInstance();
        reference=database.getReference();

    }

    private void init() {
        et_branch=findViewById(R.id.editTextbranch);
        et_rollnumber=findViewById(R.id.editTextrollnumber);
        et_mail=findViewById(R.id.editTextEmail);
        et_mobile=findViewById(R.id.editTextmobile);
        et_name=findViewById(R.id.editTextTextPersonName);
        recyclerView=findViewById(R.id.mainrec);
    }

    public void savedata(View view) {
        t_name=et_name.getText().toString();
        t_rollnumber=et_rollnumber.getText().toString();
        t_mail=et_mail.getText().toString();
        t_mobile=et_mobile.getText().toString();
        t_branch=et_branch.getText().toString();
        writeNewUser(t_name,t_rollnumber,t_branch,t_mobile,t_mail);

    }

    private void writeNewUser(String t_name, String t_rollnumber, String t_branch, String t_mobile, String t_mail) {
     pojo=new studentPojo(t_name,t_rollnumber,t_branch,t_mobile,t_mail);
     /*pojo.setBranch(t_branch);
     pojo.setName(t_name);
     pojo.setMobilenumbr(t_mobile);
     pojo.setRollNumber(t_rollnumber);
     pojo.setEmail(t_mail);*/
     list=new ArrayList<>();
     list.add(pojo);
        reference.child("students").child(t_rollnumber).push().setValue(pojo).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Register success "+t_name , Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void retriveData(View view) {
        adapter=new MyAdapter(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}