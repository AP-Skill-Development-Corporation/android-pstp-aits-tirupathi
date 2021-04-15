package com.example.roomdatabase;

import android.app.Application;
import android.app.ListActivity;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel  extends AndroidViewModel {

    MyRepository repository;
    LiveData<List<Student>> readData;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new MyRepository(application);
        readData = repository.readAllData();
    }
    public void insert(Student student){
        repository.insert(student);
    }
    public void delete(Student student){
        repository.delete(student);
    }
    public LiveData<List<Student>> readData(){
        return readData;
    }
}
