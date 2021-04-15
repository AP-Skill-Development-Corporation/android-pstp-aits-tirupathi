package com.example.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MyRepository {

    LiveData<List<Student>> readData;
    MyDataBase myDataBase;

    public MyRepository(Application application) {
        myDataBase = MyDataBase.getDataBase(application);
        readData = myDataBase.myDao().readData();
    }

    public void insert(Student student){
        new Inserttask().execute(student);
    }


    class Inserttask extends AsyncTask<Student,Void,Void>{

        @Override
        protected Void doInBackground(Student... students) {
            myDataBase.myDao().insertStudent(students[0]);
            return null;
        }
    }

    public void delete(Student student){
        new DeleteTask().execute(student);
    }
    class DeleteTask extends AsyncTask<Student,Void,Void>{

        @Override
        protected Void doInBackground(Student... students) {
            myDataBase.myDao().deleteStudent(students[0]);
            return null;
        }
    }

    public LiveData<List<Student>> readAllData(){
        return readData;
    }
}
