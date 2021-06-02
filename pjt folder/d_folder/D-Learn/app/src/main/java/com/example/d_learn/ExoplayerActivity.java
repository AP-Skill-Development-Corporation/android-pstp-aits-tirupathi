package com.example.d_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class ExoplayerActivity extends AppCompatActivity {
    WebView w;
public static final String videoUrl="https://www.youtube.com/watch?v=27TGfWd3AdI&ab_channel=boAt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exoplayer);
        w=findViewById(R.id.wb);
        /*MyWebChromeClient mWebChromeClient = new MyWebChromeClient();
        myWebView.setWebChromeClient(mWebChromeClient);
        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });*/
        WebSettings webSettings = w.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}