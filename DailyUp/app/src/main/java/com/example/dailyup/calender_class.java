package com.example.dailyup;


import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class calender_class extends AppCompatActivity {

    // Define the variable of CalendarView type
    // and TextView type;
    CalendarView calender;
    TextView date_view;
    TextView workout_view;
    HashMap<String, String> workouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("calender_test", "first");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calender_view);
        Log.i("calender_test", "second");
        calender = (CalendarView)
                findViewById(R.id.Calender);
        Log.i("calender_test", "third!");
        date_view = (TextView)
                findViewById(R.id.date_view);

        workouts = new HashMap<String, String>();

        workout_view = (TextView) findViewById(R.id.workout);
        Log.i("calender_test", "fourth");
        // Add Listener in calendar

        calender
                .setOnDateChangeListener(
                        new CalendarView.OnDateChangeListener() {

                            @Override

                            public void onSelectedDayChange(
                                    CalendarView view,
                                    int year,
                                    int month,
                                    int dayOfMonth) {
                                Log.i("calender_test", "fifth");

                                String Date
                                        = (month + 1) + "-"
                                        + dayOfMonth + "-" + year;

                                // set this date in TextView for Display
                                date_view.setText(Date);
                                Log.i("calender_test", "Got here");
                                if (workouts.containsKey(Date))
                                    workout_view.setText(workouts.get(Date));
                                else {
                                    //workout_view.setText("No Workout Selected");
                                    workout_view.setText((int) (Math.random() * 5 + 1) + " sets of 10 pushups");
                                }
                            }
                        });
    }
}