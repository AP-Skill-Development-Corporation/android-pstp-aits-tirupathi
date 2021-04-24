package com.example.paymentgateway;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements PaymentResultListener {

    /*For Generating APIKEY goto Web Site: https://razorpay.com/*/
    String APIKEY = "Paste your API KEY Here";

    Checkout checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Checkout.preload(getApplicationContext());

    }

    public void payment(View view) {
        /*intilization CHeckout*/
        checkout = new Checkout();
        /*set APIKEy to checkout*/
        checkout.setKeyID(APIKEY);

        final Activity activity = this;


        try {
            JSONObject object = new JSONObject();
            object.put("Name","Sai Sankar");
            object.put("amount","10000");
            object.put("theme.color","#44BB04");
            object.put("image","https://p7.hiclipart.com/preview/212/540/940/logo-banner-health-care-home-care-service-logo-design.jpg");
            object.put("currency","INR");
            checkout.open(activity,object);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Payment Sucess", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Fail \n "+ s , Toast.LENGTH_SHORT).show();
    }
}