package com.example.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    /*Create Insert Query*/
    @Insert
    public void insertStudent(Student student);
    /*Create Delete Query*/
    @Delete
    public void deleteStudent(Student student);
    /*Create read Query*/

    @Query("select * from StudentData")
    public LiveData<List<Student>> readData();

    /*Create Update Query*/
    @Update
    public void updateStudent(Student student);

}
