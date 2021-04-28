package com.example.week2_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*

Aaron Allen
4/26


 */

public class MainActivity extends AppCompatActivity
{
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
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


        nameEditText = findViewById(R.id.activity_main_nameEditText);
        emailEditText = findViewById(R.id.activity_main_emailEditText);
        passwordEditText = findViewById(R.id.activity_main_passwordEditText);
        loginButton = findViewById(R.id.activity_main_loginButton);

        dateOfBirth = findViewById(R.id.datePicker);
        dateOfBirth.setMaxDate(new Date().getTime());

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emailValidator(emailEditText.getText().toString()) && emailEditText.getText().length() > 0 &&
                        passwordEditText.getText().length() > 0 && nameEditText.getText().length() > 0)
                {
                    int getYearOfBirth = dateOfBirth.getYear();
                    if(!(getYearOfBirth <= 2003))
                    {
                        Toast.makeText(getApplicationContext(), "You are not old enough, you must be over 18", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Intent i = new Intent(getApplicationContext(), LoginLanding.class);
                        i.putExtra("username", "Thank you for signing up: " + nameEditText.getText().toString());
                        startActivityForResult(i, LOGGED_IN_REQUEST);
                        emailEditText.setText(null);
                        nameEditText.setText(null);
                        passwordEditText.setText(null);
                    }
                } else {
                    String toastMessage = "Make sure you filled in every field correctly!";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == LOGGED_IN_REQUEST)
        {
            if(resultCode == RESULT_OK)
            {
                Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();
                String text = data.getStringExtra("username");
            }
        }
    }
}