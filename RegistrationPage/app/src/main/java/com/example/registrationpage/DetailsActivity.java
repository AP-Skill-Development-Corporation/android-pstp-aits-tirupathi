package com.example.registrationpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.registrationpage.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
ActivityDetailsBinding detailsBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailsBinding= DataBindingUtil.setContentView(this,R.layout.activity_details);
        detailsBinding.tvDetails.setVisibility(View.VISIBLE);
        Intent i=getIntent();
        String n=i.getStringExtra("myname");
        String p=i.getStringExtra("mypassword");
        String e=i.getStringExtra("myemail");
       String m= i.getStringExtra("mymobile");
       String g= i.getStringExtra("mygender");
      String a=  i.getStringExtra("myaddress");
      detailsBinding.tvDetails.append("name:"+n+"\n"+
              "Password:"+p+"\n"+
              "email:"+e+"\n"+
              "Mobile:"+m+"\n"+
              "Gender:"+g+"\n"+
              "Address:"+a+"\n");
    }
}