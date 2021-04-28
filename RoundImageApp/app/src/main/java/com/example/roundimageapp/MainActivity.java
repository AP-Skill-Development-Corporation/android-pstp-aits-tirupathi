package com.example.roundimageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.ImageDecoder;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
/*Steps for design the round image
* from refarence https://stackoverflow.com/questions/22105775/imageview-in-circular-through-xml
* 1.// res/drawable/circle.xml
* 2. // res/drawable/img.xml
* 3.Design the Imageview in activity_main.xml file with basic attributs
* 4.get that imageview id in JAVA file
* */
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.iv);

    }
}