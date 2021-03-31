package com.muni.example.androidmenus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
int date,month,year,min,hours;
Button btn;
Spinner sp;
TextView textView_label;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.showButtion);
        sp=findViewById(R.id.spin);
        textView_label=findViewById(R.id.tv);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myHero=sp.getSelectedItem().toString();
                textView_label.setText(myHero);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.alert:
                showAlert();
                break;
            case R.id.datepicker:
                showDate();
                break;
            case R.id.timepicker:
                showTime();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showTime() {
        Calendar c=Calendar.getInstance();
        hours=c.get(Calendar.HOUR);
        min=c.get(Calendar.MINUTE);

        TimePickerDialog dialog=new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String time=hourOfDay+"-"+minute;
                Toast.makeText(MainActivity.this, "selecte your time is : "+time,
                        Toast.LENGTH_SHORT).show();
            }
        },hours,min,true);
        dialog.show();
        //Toast.makeText(this, "Item Time Picker ", Toast.LENGTH_SHORT).show();
    }

    private void showDate() {
      //  Toast.makeText(this, "Item Date picker", Toast.LENGTH_SHORT).show();

    }

    private void showAlert() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Alert..!");
        builder.setMessage("Do you close the app");
        builder.setIcon(R.drawable.ic_baseline_warning_24);
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
       // Toast.makeText(this, "Item Alert", Toast.LENGTH_SHORT).show();
    }
}