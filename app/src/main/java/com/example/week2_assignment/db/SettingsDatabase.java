package com.example.week2_assignment.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Settings.class}, version = 2)
public abstract class SettingsDatabase extends RoomDatabase
{
    private static SettingsDatabase INSTANCE;
    public abstract SettingsDao settingsDao();

    public static SettingsDatabase getDbInstance(Context context) {
        if (INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), SettingsDatabase.class,
                    "Settings_DB")
                    .allowMainThreadQueries().fallbackToDestructiveMigration()
                    .build();
        }

        return INSTANCE;
    }
}
