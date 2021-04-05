package com.example.dailyup;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Button bmiButton;
    Button plannerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bmiButton = (Button) findViewById(R.id.bmi);
        plannerButton = (Button) findViewById(R.id.planner);
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
    }

    public void openBMI(){
        Intent intent = new Intent(this, BMICalculator.class);
        startActivity(intent);
    }

    public void openPlanner(){
        Intent intent = new Intent(this, WorkoutPlanner.class);
        startActivity(intent);
    }
}