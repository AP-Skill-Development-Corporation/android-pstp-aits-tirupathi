package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView date,coutry,confirmed,active,deaths,recovered;
ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog=new ProgressDialog(this);
        dialog.setTitle("Data Fetching..");
        dialog.setMessage("Please Wait ...");
        dialog.show();
        date=findViewById(R.id.tv_date);
        coutry=findViewById(R.id.country);
        confirmed=findViewById(R.id.confirmed);
        active=findViewById(R.id.active);
        deaths=findViewById(R.id.death);
        recovered=findViewById(R.id.recoverd);
        EndpointInterface ei=RetrofitInstance.getRetrofit().create(EndpointInterface.class);
        Call<String> c=ei.getData();
        c.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                dialog.cancel();
              //  Log.i("ding",response.body());
                //Toast.makeText(MainActivity.this, ""+response.body(), Toast.LENGTH_SHORT).show();
                try {
                    JSONArray rootArray=new JSONArray(response.body());
                    JSONObject rootObj=rootArray.getJSONObject(rootArray.length()-1);
                    String res_country=rootObj.getString("Country");
                    String resDate=rootObj.getString("Date");
                    String resActive=rootObj.getString("Active");
                    String resRecovered=rootObj.getString("Recovered");
                    String resConfiremed=rootObj.getString("Confirmed");
                    String resDeaths=rootObj.getString("Deaths");

                    active.setText("Acitive:"+resActive);
                    deaths.setText("AcitiDeathsve:"+resDeaths);
                    recovered.setText("recovered:"+resRecovered);
                    confirmed.setText("Confirmed:"+resConfiremed);
                    date.setText("Date:"+resDate);
                    coutry.setText("Country:"+res_country);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to load", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
