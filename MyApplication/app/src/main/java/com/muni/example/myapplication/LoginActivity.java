package com.muni.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity  {
    private static final String TAG = "LoginActivity";
    private static final int RC_SIGN_IN = 1001;
    GoogleSignInClient googleSignInClient;
    private FirebaseAuth firebaseAuth;
    CheckBox First,Second,Third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        First = findViewById(R.id.checkBox);
        Second = findViewById(R.id.checkBox2);
        Third = findViewById(R.id.checkBox3);

/*        First.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Second.isChecked()){
                    lng="option2";
                }
            }
        });
        Third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Third.isChecked()){
                    lng="option3";
                }
            }
        });*/
        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                // Launch Sign In
                signInToGoogle();
            }
        });
        // Configure Google Client
        configureGoogleClient();
    }
    private void configureGoogleClient() {
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                // for the requestIdToken, this is in the values.xml file that
                // is generated from your google-services.json
                .requestIdToken("getString(R.string.default_web_client_id)")
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        googleSignInClient = GoogleSignIn.getClient(this, gso);
        // Set the dimensions of the sign-in button.
        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_WIDE);
        // Initialize Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance();
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null) {
            Log.d(TAG, "Currently Signed in: " + currentUser.getEmail());
            showToastMessage("Currently Logged in: " + currentUser.getEmail());
        }
    }
    public void signInToGoogle() {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                showToastMessage("Google Sign in Succeeded");
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                showToastMessage("Google Sign in Failed " + e);
            }
        }
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Log.d(TAG, "signInWithCredential:success: currentUser: " + user.getEmail());
                            showToastMessage("Firebase Authentication Succeeded ");
                            launchMainActivity(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            showToastMessage("Firebase Authentication failed:" + task.getException());
                        }
                    }
                });
    }
    private void showToastMessage(String message) {
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
    }
    private void launchMainActivity(FirebaseUser user) {
        if (user != null) {
            MainActivity.startActivity(this, user.getDisplayName());
            finish();
        }
    }

   /* public void show(View view) {
        String lng="";
       // public void onCheckboxClicked(View view) {
            // Is the view now checked?
            boolean checked = ((CheckBox) view).isChecked();

            // Check which checkbox was clicked
            switch(view.getId()) {
                case R.id.checkBox:
                    if (checked){
                        lng="option1";
                    }
                    // Put some meat on the sandwich
           // else
                    // Remove the meat
                    break;
                case R.id.checkBox2:
                    if (checked){
                        lng="option2";
                    }
                    // Cheese me
            //else
                    // I'm lactose intolerant
                    break;
                case R.id.checkBox3:
                    if (checked){
                        lng="option3";
                    }
                // TODO: Veggie sandwich
           // }
        }*/
       /* switch(view.getId()){
            case R.id.checkBox:
                if (First.isChecked()){
                    lng="option1";
                }
                break;
            case R.id.checkBox2:
                if (Second.isChecked()){
                    lng="option2";
                }
                break;
            case R.id.checkBox3:
                if (Third.isChecked()){
                    lng="option3";
                }
                break;

        }*/
     //   Toast.makeText(this, ""+lng, Toast.LENGTH_SHORT).show();
   // }
    public void show(View view) {
        // Is the view now checked?
        String l="";
        if (First.isChecked() && Second.isChecked() && Third.isChecked())
        {
            l="o1"+"\n"+"o2"+"o3";
        }
        else if (First.isChecked() && Second.isChecked()) {
            l="o1"+"\n"+"o2";

        }
        else if (First.isChecked() ) {
            l="o1";

        }
        else if (First.isChecked() && Third.isChecked() ) {
            l="o1"+"o3";

        }
        else if (Second.isChecked() && Third.isChecked() ) {
            l="o2"+"o3";

        }
        else if (Third.isChecked() ) {
            l="o3";

        }
        else if (Second.isChecked() ) {
            l="o2";

        }
        Toast.makeText(this, ""+l, Toast.LENGTH_SHORT).show();
        }

    }
