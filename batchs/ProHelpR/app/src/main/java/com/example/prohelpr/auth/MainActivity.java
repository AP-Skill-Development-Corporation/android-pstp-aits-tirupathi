package com.example.prohelpr.auth;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prohelpr.R;
import com.example.prohelpr.users.UsersHome;
import com.example.prohelpr.workers.WorkerHome;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editTextCountryCode;
    private TextInputEditText editTextPhone;
    private Button buttonContinue;
    RadioButton selectrole, worker, user;
    String selectedRbText, compare;
    RadioGroup roles;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roles = findViewById(R.id.roles);

        worker = findViewById(R.id.workerregiser);
        user = findViewById(R.id.userregister);
        worker.setChecked(Update("role_worker"));
        user.setChecked(Update("role_user"));
        editTextCountryCode = (TextInputEditText) findViewById(R.id.editTextCountryCode);
        editTextPhone = (TextInputEditText) findViewById(R.id.editTextPhone);
        buttonContinue = (Button) findViewById(R.id.buttonContinue);

        worker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                savedata("role_worker", isChecked);
            }
        });


        user.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                savedata("role_user", isChecked);
            }
        });


        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           /*     String code = editTextCountryCode.getText().toString().trim();
                String number = editTextPhone.getText().toString().trim();

                if (number.isEmpty() || number.length() < 10) {
                    editTextPhone.setError("Valid number is required");
                    editTextPhone.requestFocus();
                    return;
                }

                String phoneNumber = code + number;

                int selectedRadioButtonId = roles.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    selectrole = findViewById(selectedRadioButtonId);
                    selectedRbText = selectrole.getText().toString();
                    prefs = getApplicationContext().getSharedPreferences("USER_PREF",
                            Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("role", selectedRbText);
                    editor.apply();
                } else {
                    Toast.makeText(MainActivity.this, "Nothing selected from the Avaliable Role", Toast.LENGTH_SHORT).show();
                }
                compare = prefs.getString("role", NULL);

                Intent intent = new Intent(MainActivity.this, VerifyPhoneActivity.class);
                intent.putExtra("phoneNumber", phoneNumber);
                intent.putExtra("role", selectedRbText);
                startActivity(intent);*/
                Intent intent = new Intent(MainActivity.this, VerifyPhoneActivity.class);
                intent.putExtra("phoneNumber", "9999999999");
                intent.putExtra("role", selectedRbText);
                startActivity(intent);
            }
        });
    }

   /* @Override
    protected void onStart() {
        super.onStart();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            if (worker.getText().toString().equals("Worker")) {
                Intent intent = new Intent(this, WorkerHome.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
            else if (user.getText().toString().equals("User")) {
                Intent intent = new Intent(this, UsersHome.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }

       *//* if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            Intent intent = new Intent(this, WorkerHome.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }*//*
    }
*/
    public void savedata(String key, boolean value) {
        prefs = getApplicationContext().getSharedPreferences("USER_PREF",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean Update(String key) {
        prefs = getApplicationContext().getSharedPreferences("USER_PREF", Context.MODE_PRIVATE);
        return prefs.getBoolean(key, false);
    }


}