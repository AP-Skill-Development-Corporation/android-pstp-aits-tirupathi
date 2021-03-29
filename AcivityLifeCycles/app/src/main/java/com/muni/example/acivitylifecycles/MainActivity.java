package com.muni.example.acivitylifecycles;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
int day,month,year;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView2);
    }

    public void showDate(View view) {
        Calendar c=Calendar.getInstance();
        day=c.get(Calendar.DATE);
        month=c.get(Calendar.MONTH);
        year=c.get(Calendar.YEAR);
        DatePickerDialog dp=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            /*all monthes will stores in form arrays 0 -11*/
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
               tv.append(year+"-"+(month+1)+"-"+dayOfMonth);
            }
        },year,month,day);
        dp.show();
    }

    public void showTime(View view) {
    }
}