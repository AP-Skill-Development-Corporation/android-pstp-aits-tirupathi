package com.example.prohelpr.users;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prohelpr.R;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;


public class UserProfileFragment extends Fragment {

    String phoneNumber,roledata;
    TextView mobileNumber,role,username,useraddress,useralternatemobilenumber,saveuser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_user_profile, container, false);
        // get saved phone number
        SharedPreferences prefs =  getActivity().getSharedPreferences("USER_PREF",
                Context.MODE_PRIVATE);
        phoneNumber = prefs.getString("phoneNumber", NULL);
        roledata = prefs.getString("role",NULL);
        mobileNumber = v.findViewById(R.id.mobileNumber);
        role = v.findViewById(R.id.roledefine);
        role.setText("Your Role Is : "+roledata);
        username=v.findViewById(R.id.user_name);
        useraddress=v.findViewById(R.id.user_address);
        saveuser=v.findViewById(R.id.save_user);
        useralternatemobilenumber=v.findViewById(R.id.worker_user_alternatenumber);
        mobileNumber.setText(phoneNumber);
        v.findViewById(R.id.save_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "User Data Update Sucessfully", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}