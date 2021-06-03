package com.example.week2_assignment.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SettingsDao
{
    @Query("SELECT * FROM Settings")
    List<Settings> getAll();

    @Insert
    void insertSettings(Settings... settings);
}
