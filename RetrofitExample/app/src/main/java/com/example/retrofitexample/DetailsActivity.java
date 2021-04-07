package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView date, coutry, confirmed, active, deaths, recovered;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        date = findViewById(R.id.tv_date_details);
        coutry = findViewById(R.id.country);
        confirmed = findViewById(R.id.confirmed);
        active = findViewById(R.id.active);
        deaths = findViewById(R.id.death);
        recovered = findViewById(R.id.recoverd);

    }
}
