package com.example.prohelpr.workers;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prohelpr.R;
import com.example.prohelpr.Worker_Home_data;

public class WorkerHomeFragment extends Fragment {


    RecyclerView rv;

    String[] data = {"MyData","MyData"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_worker_home, container, false);
        rv = v.findViewById(R.id.w_h_recycler);
        rv.setAdapter(new Worker_Home_data(getContext(),data));
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }
}