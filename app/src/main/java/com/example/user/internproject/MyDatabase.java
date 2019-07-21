package com.example.user.internproject;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {PersonModel.class},version = 1,exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract EmployeeDao employeeDao();
}
