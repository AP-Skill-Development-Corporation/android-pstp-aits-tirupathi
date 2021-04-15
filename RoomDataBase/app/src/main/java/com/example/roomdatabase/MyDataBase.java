package com.example.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class} , version = 1 ,exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {
    /*Create Abstarct menthod for Dao class*/
    public abstract MyDao myDao();

    /*Create Database*/
    public static MyDataBase dataBase;

    public static synchronized MyDataBase getDataBase(Context ct){
        if (dataBase == null){
            dataBase = Room.databaseBuilder(ct,
                    MyDataBase.class,"MyDb")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return dataBase;
    }



}
