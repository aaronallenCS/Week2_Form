package com.example.week2_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*

Aaron Allen
5/4


 */

public class MainActivity extends AppCompatActivity
{
    private EditText nameEditText;
    private EditText description;
    private EditText occupation;
    private DatePicker dateOfBirth;
    private Button loginButton;

    private static final int LOGGED_IN_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setBackgroundColor(Color.rgb(255, 182, 193));
        getSupportActionBar().hide();


        nameEditText = findViewById(R.id.name_et);
        description = findViewById(R.id.description_et);
        occupation = findViewById(R.id.occupation_et);
        dateOfBirth = findViewById(R.id.datePicker);
        loginButton = findViewById(R.id.activity_main_loginButton);

        dateOfBirth.setMaxDate(new Date().getTime());


        Calendar c = Calendar.getInstance();


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (nameEditText.getText().length() > 0 && occupation.getText().length() > 0 && description.getText().length() > 0)
                {
                    int getYearOfBirth = dateOfBirth.getYear();
                    int getMonthOfBirth = dateOfBirth.getMonth() + 1;
                    int getDayOfBirth = dateOfBirth.getDayOfMonth();
                    String dob = getMonthOfBirth + "/" +  getDayOfBirth;

                    LocalDate now = LocalDate.now();
                    LocalDate birthday = LocalDate.of(getYearOfBirth, getMonthOfBirth, getDayOfBirth);
                    Period period = Period.between(birthday, now);
                    int years = period.getYears();
                    Log.d("TYES", years+"");
                    if(years >= 18)
                    {

                        Intent i = new Intent(getApplicationContext(), LoginLanding.class);
                        i.putExtra("name", nameEditText.getText().toString());
                        i.putExtra("description", description.getText().toString());
                        i.putExtra("occupation", occupation.getText().toString());
                        i.putExtra("DOB", dob);

                        startActivityForResult(i, LOGGED_IN_REQUEST);
                        nameEditText.setText(null);
                        description.setText(null);
                        occupation.setText(null);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "You are not old enough, you must be over 18", Toast.LENGTH_LONG).show();
                    }
                } else {
                    String toastMessage = "Make sure you filled in every field correctly!";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == LOGGED_IN_REQUEST)
        {
            if(resultCode == RESULT_OK)
            {
                String name = data.getStringExtra("name");
                String description = data.getStringExtra("description");
                String occupation = data.getStringExtra("occupation");
                String dob = data.getStringExtra("DOB");
            }
        }
    }
}
