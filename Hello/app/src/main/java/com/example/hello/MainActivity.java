package com.example.hello;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView text;
int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       text=findViewById(R.id.tv);
       if (savedInstanceState!=null&&savedInstanceState.containsKey("anykey")){
           count=savedInstanceState.getInt("anykey");
           text.setText(String.valueOf(count));
       }
    }
    public void showToast(View view) {
        /*Syntax of the toast message*/
        Toast.makeText(this, "This is our first own app", Toast.LENGTH_SHORT).show();
    }

    public void showCount(View view) {
        count++;
        text.setText(String.valueOf(count));
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("anykey",count);
    }
}