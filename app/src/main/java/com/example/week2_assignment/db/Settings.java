package com.example.week2_assignment.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Settings")
public class Settings
{
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "reminder_time")
    public String reminderTime;
    @ColumnInfo(name = "max_distance")
    public int maxDistance;
    @ColumnInfo(name = "gender")
    public String gender;
    @ColumnInfo(name = "private_public_account")
    public String privateOrPublic;
    @ColumnInfo(name="age_preference")
    public int ageRange;

    public void setReminderTime(String reminderTime)
    {
        this.reminderTime = reminderTime;
    }

    public void setMaxDistance(int maxDistance)
    {
        this.maxDistance = maxDistance;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public void setPrivateOrPublic(String privateOrPublic)
    {
        this.privateOrPublic = privateOrPublic;
    }

    public void setAgeRange(int ageRange)
    {
        this.ageRange = this.ageRange;
    }

}
