package com.example.dailyup;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Button bmiButton;
    Button plannerButton;
    Button foodButton;
    Button calenderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //on click listener for buttons
        bmiButton = (Button) findViewById(R.id.bmi);
        plannerButton = (Button) findViewById(R.id.planner);
        foodButton = (Button) findViewById(R.id.diet);
        calenderButton = (Button) findViewById(R.id.calender_btn);

        bmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBMI();
            }
        });
        plannerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlanner();
            }
        });
        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDiet();
            }
        });
        calenderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalender();
            }
        });
    }

    //functions to start new activities
    public void openBMI(){
        Intent intent = new Intent(this, BMICalculator.class);
        startActivity(intent);
    }

    public void openPlanner(){
        Intent intent = new Intent(this, WorkoutPlanner.class);
        startActivity(intent);
    }

    public void openDiet(){
        Intent intent = new Intent(this, DietPlanner.class);
        startActivity(intent);
    }

    public void openCalender(){
        Intent intent = new Intent(this, calender_class.class);
        startActivity(intent);
    }
}