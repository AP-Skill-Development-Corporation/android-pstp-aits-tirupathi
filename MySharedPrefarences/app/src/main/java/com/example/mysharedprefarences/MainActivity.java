package com.example.mysharedprefarences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText n,p;
SharedPreferences sp;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n=findViewById(R.id.editTextTextPersonName);
        p=findViewById(R.id.editTextTextPersonName2);
        sp=getSharedPreferences("myname",MODE_PRIVATE);

    }

    public void savedata(View view) {
        String myname=n.getText().toString();
        String mypassword=p.getText().toString();
        Toast.makeText(this, ""+myname+"\n"+
                mypassword, Toast.LENGTH_SHORT).show();
        editor=sp.edit();
        editor.putString("key-name",myname);
        editor.putString("key-password",mypassword);
        editor.commit();

    }

    public void retrivedata(View view) {
        String s=sp.getString("key-name","");
        String s1=sp.getString("key-password","");
        n.setText(s);
        p.setText(s1);


    }
}