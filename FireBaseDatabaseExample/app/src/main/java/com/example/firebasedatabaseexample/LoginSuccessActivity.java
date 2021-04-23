package com.example.firebasedatabaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class LoginSuccessActivity extends AppCompatActivity {
AnimationDrawable drawable;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        imageView = findViewById(R.id.iv);
      //  imageView.setBackgroundResource(R.drawable.flag);
    }
}