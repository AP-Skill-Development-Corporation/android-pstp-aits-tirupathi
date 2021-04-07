package com.example.covid19reports;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
TextView country,date,active,recovered,deaths,confiremed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        country=findViewById(R.id.tv_country);
        date=findViewById(R.id.date_tv);
        active=findViewById(R.id.tv_active);
        recovered=findViewById(R.id.tv_recovered);
        deaths=findViewById(R.id.tv_deaths);
        confiremed=findViewById(R.id.tv_confiremed);
        EndpointInterface ei=Covid19Responds.getInstance()
                                            .create(EndpointInterface.class);
        /*Call<String> c=ei.getData();
        c.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("ding",response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "something went wrong while fetch data", Toast.LENGTH_SHORT).show();
            }
        });
*/
    }
}
