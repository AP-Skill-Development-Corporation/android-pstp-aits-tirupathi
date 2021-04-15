package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    EditText uname,umail,uphone,uroll;
    RadioButton umale,ufemale;
    CheckBox utelugu,uenglish,uhindi;
    Spinner dept;

    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        uname = findViewById(R.id.username);
        umail = findViewById(R.id.usermail);
        uphone = findViewById(R.id.userphone);
        uroll = findViewById(R.id.userroll);

        umale = findViewById(R.id.male);
        ufemale = findViewById(R.id.female);

        utelugu = findViewById(R.id.telugu);
        uenglish = findViewById(R.id.english);
        uhindi = findViewById(R.id.hindi);

        dept = findViewById(R.id.department);

    }

    public void save(View view) {
        /*Read Values from EditText*/
        String name = uname.getText().toString();
        String mailid = umail.getText().toString();
        String phone = uphone.getText().toString();
        String roll = uroll.getText().toString();

        /*Read Value from Radio Buttons*/
        if (umale.isChecked()){
            gender = umale.getText().toString();
        }
        if (ufemale.isChecked()){
            gender = ufemale.getText().toString();
        }

        /*Read Values from CheckBox*/

        StringBuilder sb = new StringBuilder();

        if (utelugu.isChecked()){
            sb.append(utelugu.getText().toString()+",");
        }
        if (uenglish.isChecked()){
            sb.append(uenglish.getText().toString()+",");
        }
        if (uhindi.isChecked()){
            sb.append(uhindi.getText().toString());
        }

        /*Read values from Spinner*/
        String department = dept.getSelectedItem().toString();

        /*Toast.makeText(this, name+"\n"+mailid+"\n"
                +phone+"\n"+roll+"\n"+gender+"\n"+department+"\n"+sb.toString(),
                Toast.LENGTH_SHORT).show();*/
        Student student = new Student();
        student.setName(name);
        student.setMailID(mailid);
        student.setPhoneNumber(phone);
        student.setRollNumber(roll);
        student.setGender(gender);
        student.setLanguage(sb.toString());
        student.setDepartment(department);

        //MainActivity.dataBase.myDao().insertStudent(student);

        MainActivity.viewModel.insert(student);

        Toast.makeText(this, "Data Saved Sucessfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}
