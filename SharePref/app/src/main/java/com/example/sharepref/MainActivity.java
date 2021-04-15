package com.example.sharepref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText edit_t;
SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_t=findViewById(R.id.editText);
        sharedPreferences=getSharedPreferences("ad",MODE_PRIVATE);


    }

    @Override
    protected void onPause() {
        super.onPause();
        String s=edit_t.getText().toString();
        editor=sharedPreferences.edit();
        editor.putString("aa",s);
        editor.commit();
        String sss=sharedPreferences.getString("aa","");
        edit_t.setText(sss);

    }

    @Override
    protected void onResume() {
        super.onResume();
        String s=edit_t.getText().toString();
        editor=sharedPreferences.edit();
        editor.putString("aa",s);
        editor.commit();
       // SharedPreferences sharedPreferences=getSharedPreferences("ad",MODE_PRIVATE);
        String sss=sharedPreferences.getString("aa","");
        edit_t.setText(sss);
    }

    public void show(View view) {
       // SharedPreferences sharedPreferences1=getSharedPreferences("ad",MODE_PRIVATE);

    }
}
