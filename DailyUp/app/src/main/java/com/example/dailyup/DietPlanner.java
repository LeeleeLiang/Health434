package com.example.dailyup;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Spinner;

public class DietPlanner extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        Spinner dropdown = findViewById(R.id.spinner1);
        String[] activity = new String[]{"No exercise", "Exercise 1-3 times a week",
                "Exercise 4-6 times a week", "Daily exercise"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, activity);
        dropdown.setAdapter(adapter);
    }
}