package com.example.registrationpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.registrationpage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
String gender,knowNCourses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

    }

    public void showData(View view) {
        /*MainAcivity.this
        * or
        * this
        * or
        * context
        * or
        * getApplicationContext()
        * or getContext()*/
        String name=binding.etUsername.getText().toString();
        String email=binding.etUsermail.getText().toString();
        String mobile=binding.etUserMobileNumber.getText().toString();
        String password=binding.etUserpassword.getText().toString();
        String address=binding.etAddress.getText().toString();

        if (binding.male.isChecked()){
            gender="Male";
        }else if(binding.female.isChecked()){
            gender="Female";
        }
        Intent intentObj=new Intent(this,DetailsActivity.class);
        intentObj.putExtra("myname",name);
        intentObj.putExtra("myemail",email);
        intentObj.putExtra("mymobile",mobile);
        intentObj.putExtra("mypassword",password);
        intentObj.putExtra("myaddress",address);
        intentObj.putExtra("mygender",gender);
        startActivity(intentObj);
    }
}