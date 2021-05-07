package com.example.prohelpr.workers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.prohelpr.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WorkerHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.w_bottomNavigationView);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new WorkerHomeFragment());

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.w_home:
                    fragment = new WorkerHomeFragment();
                    loadFragment(fragment);
                    // toolbar.setTitle("Shop");
                    return true;
                case R.id.w_bookings:
                    fragment = new WorkerBookingFragment();
                    loadFragment(fragment);
                    // toolbar.setTitle("My Gifts");
                    return true;

                case R.id.w_profile:
                    fragment = new WorkerProfileFragment();
                    loadFragment(fragment);
                    // toolbar.setTitle("Profile");
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flFragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}