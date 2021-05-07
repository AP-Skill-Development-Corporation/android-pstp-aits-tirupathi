package com.example.prohelpr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;


import com.example.prohelpr.auth.MainActivity;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);*/
    }

    public void nextActivity(View view) {
        Intent i = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}