package com.example.asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button b1;
    ImageView iv;
    TextView tv;

    String myurl= "https://pixabay.com/api/?key=8907574-f2ba82f0d1e5cef1d06a114e6&q=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.imagename);
        b1 = findViewById(R.id.submit);
        iv = findViewById(R.id.imageview);
        tv = findViewById(R.id.textview);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ImageTask().execute();
            }
        });
    }

    class ImageTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            /*Call your URl*/
            try {
                URL url = new URL(myurl);
                /*Internet Checking*/
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                /*getting Input*/
                InputStream inputStream = urlConnection.getInputStream();
                Scanner scanner = new Scanner(inputStream);
                /*to read starting object to ending object*/
                scanner.useDelimiter("aaa");
                if (scanner.hasNext()){
                    return scanner.next();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }
}
