package com.example.user.internproject;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

// EmployeeDao for LocalFragment

@Dao
public interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(List<PersonModel>personModels);

    @Query("SELECT * FROM employee")
    List<PersonModel>getAll();

}
