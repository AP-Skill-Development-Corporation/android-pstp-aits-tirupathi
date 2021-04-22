package com.example.firebasedatabaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Script;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText empName,employeeId,empSal;
FirebaseDatabase database;
DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        empName=findViewById(R.id.empname);
        employeeId=findViewById(R.id.empId);
        empSal=findViewById(R.id.empSalaray);
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
            Employee employee=new Employee(ename,eid,esalary);
            reference.child(ename).push().setValue(employee)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    empName.setText("");
                    employeeId.setText("");
                    empSal.setText("");
                    Toast.makeText(MainActivity.this, "saved success"+ename, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}