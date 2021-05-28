package com.example.youtubeintigration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView webview1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview1=(WebView) findViewById(R.id.webview);
        webview1.setWebViewClient(new WebViewClient());
        //String url=getIntent().getStringExtra("");
       // webview1.loadUrl("https://www.javatpoint.com/python-features");
        webview1.loadUrl("https://google-developer-training.github.io/android-developer-fundamentals-course-concepts-v2/index.html");
    }
}