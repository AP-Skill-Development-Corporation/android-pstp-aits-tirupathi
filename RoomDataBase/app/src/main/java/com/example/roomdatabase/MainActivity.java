package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    static MyDataBase dataBase;
    List<Student> studentList;
    RecyclerView rv;
    static MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.recycler);

        viewModel = ViewModelProviders.of(this).get(MyViewModel.class);

      /*  dataBase = Room.databaseBuilder(this,
                MyDataBase.class,"MyDb")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();*/

        //studentList = dataBase.myDao().readData();

        viewModel.readData().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rv.setAdapter(new DataAdapter(MainActivity.this,students));
            }
        });

        //Toast.makeText(this, ""+studentList.size(), Toast.LENGTH_SHORT).show();

    }

    public void insertdata(View view) {
        Intent i = new Intent(this,InsertActivity.class);
        startActivity(i);
    }
}
