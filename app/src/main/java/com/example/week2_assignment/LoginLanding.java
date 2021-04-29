package com.example.week2_assignment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginLanding extends AppCompatActivity
{
    TextView name;
    TextView description;
    TextView occupation;
    TextView dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_landing);

        getWindow().getDecorView().setBackgroundColor(Color.rgb(255, 182, 193));

        name = findViewById(R.id.name_tv);
        description = findViewById(R.id.description_tv);
        occupation = findViewById(R.id.occupation_tv);
        dob = findViewById(R.id.age_tv);

        name.setText(getIntent().getStringExtra("name"));
        description.setText(getIntent().getStringExtra("description"));
        occupation.setText(getIntent().getStringExtra("occupation"));
        dob.setText(getIntent().getStringExtra("DOB"));
    }

}