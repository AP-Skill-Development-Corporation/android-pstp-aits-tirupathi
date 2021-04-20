package com.example.loginandregisterfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
EditText et_username,et_password;
    private FirebaseAuth mAuth;
    Button signoutbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_username=findViewById(R.id.editText3);
        et_password=findViewById(R.id.editText4);
        mAuth=FirebaseAuth.getInstance();
        signoutbutton=findViewById(R.id.button5);
    }

    public void showLogin(View view) {
        String email=et_username.getText().toString();
        String password=et_password.getText().toString();
        if (email.isEmpty()&&password.isEmpty()){
            Toast.makeText(this, "please fill the details", Toast.LENGTH_SHORT).show();
        }else {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                signoutbutton.setVisibility(View.VISIBLE);
                                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                           /*new AlertDialog.Builder(getApplicationContext())
                                   .setTitle("Login Success!!")
                                   .setMessage("Congrats..! you got grete job..!")
                                   .setIcon(R.mipmap.ic_launcher)
                                   .show();*/
                            }
                        }
                    });
        }
    }

    public void registerEvent(View view) {
        String email=et_username.getText().toString();
        String password=et_password.getText().toString();
        if (email.isEmpty()&&password.isEmpty()){
            Toast.makeText(this, "email and password is empty", Toast.LENGTH_SHORT).show();
        }else {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "registered success", Toast.LENGTH_SHORT).show();
                            }
                            et_username.setText("");
                            et_password.setText("");

                        }
                    });

        }
    }

    public void forgotPasswordEvent(View view) {
        Intent intent=new Intent(this,ForgotPasswordActivity.class);
        startActivity(intent);
    }

    public void signOutevent(View view) {
        mAuth.signOut();
        Toast.makeText(this, "signout", Toast.LENGTH_SHORT).show();
    }
}
