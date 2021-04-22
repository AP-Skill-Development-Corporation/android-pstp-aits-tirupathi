package com.example.firebasedatabaseexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Script;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText empName,employeeId,empSal;
FirebaseDatabase database;
DatabaseReference reference;
RecyclerView recycle;
EmployeeAdapter adapter;
    Employee employee;
    List<Employee> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        empName=findViewById(R.id.empname);
        employeeId=findViewById(R.id.empId);
        empSal=findViewById(R.id.empSalaray);
        recycle=findViewById(R.id.rec);
        database= FirebaseDatabase.getInstance();
        reference=database.getReference("Employees");

    }

    public void saveDatatoFirebase(View view) {
        String ename=empName.getText().toString();
        String eid=employeeId.getText().toString();
        String esalary=empSal.getText().toString();
        if (ename.isEmpty() && eid.isEmpty() && esalary.isEmpty()){
            Toast.makeText(this, "please fill the details", Toast.LENGTH_SHORT).show();
        }else {
             employee=new Employee(ename,eid,esalary);
            reference.child(ename).push().setValue(employee)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    empName.setText("");
                    employeeId.setText("");
                    empSal.setText("");
                    Toast.makeText(MainActivity.this, "saved success"+ename, Toast.LENGTH_SHORT).show();
                    /*Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);*/
                }
            });
        }
    }

    public void retriveDatatoFirebase(View view) {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
              list=new ArrayList<>();
              list.add(employee);
              adapter=new EmployeeAdapter(getApplication(),list);
              recycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
              recycle.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        });

    }
}