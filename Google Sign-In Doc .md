# Android -Google Sign-In Intigration to android application with Google Account 

* Source From Offical Documentation https://developers.google.com/identity/sign-in/android/sign-in
* sample app design shown below 
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign.png">

* Step-1:Create new android studio project with **empty activtiy**
* And open this site https://developers.google.com/identity/sign-in/android/start-integrating
     -  Login the Gmail-account
     -  Read the Prerequisites and Add the below dependancy (at build.gradle file module:app)

``` XML 
     //at build.gradle file
  dependencies {
        //for google sign-in activity need to add below dependancy 
        implementation 'com.google.android.gms:play-services-auth:19.0.0'
    }
```  
* In the WEB follow the below steps:
* Click on the **Configure a project** button

<img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(41).png">

* Give the project name. (you may create new or else use exist project).Here creating new project
<img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(42).png">

* project name My Project
<img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(43).png">
* next,Configure your OAuth Client (Just fill the any refarence name) .here **mygooglesign** were giving 
<img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(44).png">
 
<img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(45).png">
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(46).png">
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(47).png ">      
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(48).png">  
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(49).png">  
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(50).png"> 
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(51).png"> 
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(52).png"> 
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(53).png"> 
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(54).png">  
## Practical Implimenation code:(android studio ide version 4.1.3 used ) 
* After creation of new project open the gradle script file(build.gradle (module:app)level
```XML
plugins {
    id 'com.android.application'
}

android {
    compileSdkVersion 29
    buildToolsVersion "29.0.3"
 
    defaultConfig {
        applicationId "com.example.gsignin_intigration"
        minSdkVersion 16
        targetSdkVersion 29
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'com.google.android.material:material:1.3.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
    testImplementation 'junit:junit:4.+'

    androidTestImplementation 'androidx.test.ext:junit:1.1.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'
    /*below dependaancy for Google Sign*/
    implementation 'com.google.android.gms:play-services-auth:19.0.0'
    implementation 'com.github.bumptech.glide:glide:3.7.0'
}
```

* activity_main.xml file
```XML
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:layout_margin="2dp"
    tools:context=".MainActivity">
    <LinearLayout
        android:id="@+id/detailsLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:orientation="horizontal">
        <ImageView
            android:layout_width="150dp"
            android:layout_height="150dp"
            android:id="@+id/displayPic"
            android:src="@mipmap/ic_launcher"/>
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:orientation="vertical"
            android:layout_margin="2dp">
            <TextView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                tools:text="dummy"
                android:layout_margin="2dp"
                android:id="@+id/displayName"
                android:textAppearance="@style/TextAppearance.AppCompat.Headline"/>
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                tools:text="dummy"
                android:id="@+id/email"
                android:layout_margin="2dp"
                android:textAppearance="@style/TextAppearance.AppCompat.Body1"
                android:layout_marginTop="10dp"/>
            <Button
                android:id="@+id/sign_Out_button"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="logout"

                android:drawableLeft="@drawable/glogo" />


        </LinearLayout>
    </LinearLayout>
    <com.google.android.gms.common.SignInButton
        android:id="@+id/sign_in_button"
        android:layout_width="wrap_content"
        android:layout_marginTop="40dp"
        android:layout_height="wrap_content" />
</LinearLayout>

```

*MainActivity.java file
```JAVA

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener,View.OnClickListener {
    private static final int RC_SIGN_IN = 1;
    private static final String TAG = "MainActivity";
    private GoogleApiClient mGoogleApiClient;
    private SignInButton signInButton;
    private TextView mtextStatus, mEmail;
    private ImageView profilePic;
    private LinearLayout mLinearLayout;
    private Button sign_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sign_out = (Button) findViewById(R.id.sign_Out_button);
        mtextStatus = (TextView) findViewById(R.id.displayName);
        mEmail = (TextView) findViewById(R.id.email);
        profilePic = (ImageView) findViewById(R.id.displayPic);
        mLinearLayout = (LinearLayout) findViewById(R.id.detailsLayout);
        mLinearLayout.setVisibility(View.GONE);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        // Set the dimensions of the sign-in button.
        signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        findViewById(R.id.sign_in_button).setOnClickListener(this);
        sign_out.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                signIn();
                break;
            case R.id.sign_Out_button:
                signOut();
                break;
            // ...
        }
        

    }

    private void signOut() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        // Write whatever you like to notify the user
                        mLinearLayout.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), "You have been Logged out Sccessfully ", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this, "connection faild", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result)
    {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {

            // Signed in successfully, show authenticated UI.
            mLinearLayout.setVisibility(View.VISIBLE);
            GoogleSignInAccount acct = result.getSignInAccount();
            String email = acct.getEmail().toString();
            mtextStatus.setText(""+acct.getDisplayName());
            mEmail.setText(""+email);
            Uri pic = acct.getPhotoUrl();
            Glide.with(this).load(pic).into(profilePic);

        } else {
            // Signed out, show unauthenticated UI.
            Toast.makeText(this, "sign out", Toast.LENGTH_SHORT).show();

        }
    }
}
```
* At Drawable file added glogo.png file 👉--> https://github.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/blob/master/g-sign%20images/glogo.png
👍👍👍👍👍👍👍👍👍👍👍👍👍👍👍👍👍👍👍Run your app👍👍👍👍👍👍👍👍👍👍👍👍👍👍👍👍👍👍👍👍
