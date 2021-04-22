package com.example.spinner;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    // these are the global variables
    Spinner classSpinner, divSpinner;
    // string variable to store selected values
    String selectedClass, selectedDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classSpinner = (Spinner) findViewById(R.id.classSpinner);
        divSpinner = (Spinner) findViewById(R.id.divSpinner);

        // Class Spinner implementing onItemSelectedListener
        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedClass = parent.getItemAtPosition(position).toString();
                switch (selectedClass)
                {
                    case "Class 1":
                        // assigning div item list defined in XML to the div Spinner
                        divSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_1)));
                        break;

                    case "Class 2":
                        divSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_2)));
                        break;

                    case "Class 3":
                        divSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_3)));
                        break;

                    case "Class 4":
                        divSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_4)));
                        break;
                }

                //set divSpinner Visibility to Visible
                divSpinner.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });

        // Div Spinner implementing onItemSelectedListener
        divSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                selectedDiv = parent.getItemAtPosition(position).toString();
                /*
                    Now that we have both values, lets create a Toast to
                    show the values on screen
                */
                Toast.makeText(MainActivity.this, "\n Class: \t " + selectedClass +
                        "\n Div: \t" + selectedDiv, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }

        });
    }
}