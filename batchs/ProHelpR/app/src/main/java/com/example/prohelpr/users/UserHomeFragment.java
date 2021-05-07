package com.example.prohelpr.users;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prohelpr.R;
import com.example.prohelpr.workers.WorkerDetailsViewAdaper;
import com.example.prohelpr.workers.WorkersPojoModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class UserHomeFragment extends Fragment {
    RecyclerView recyclerView;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    WorkersPojoModel pojoModel;
    Button v_btn;
    ArrayList<WorkersPojoModel> workersPojoModelList;
    WorkerDetailsViewAdaper workerDetailsViewAdaper;


    public UserHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vi = inflater.inflate(R.layout.fragment_user_home, container, false);
        recyclerView = vi.findViewById(R.id.w_b_recycler);
        v_btn = vi.findViewById(R.id.save_btn);
        database=FirebaseDatabase.getInstance();
        databaseReference = database.getInstance().getReference("WorkersDatabase");
        v_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(getContext(), "ding", Toast.LENGTH_SHORT).show();
                //  list = new ArrayList<>();

                workersPojoModelList = new ArrayList<>();
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        workersPojoModelList.clear();
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                          //  Toast.makeText(getContext(), ""+dataSnapshot.getValue(), Toast.LENGTH_SHORT).show();
                            //pojoModel=new WorkersPojoModel();
                             pojoModel = dataSnapshot.getValue(WorkersPojoModel.class);
                            workersPojoModelList.add(pojoModel);
                            //Toast.makeText(getContext(), "ting" + dataSnapshot.getValue().toString(), Toast.LENGTH_SHORT).show();
                            break;
                        }

                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(new WorkerDetailsViewAdaper(workersPojoModelList, getContext()));

                        // adapter.notifyDataSetCahanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        return vi;
    }
}