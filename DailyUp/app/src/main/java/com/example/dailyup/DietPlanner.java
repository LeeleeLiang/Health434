package com.example.dailyup;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class DietPlanner extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView calorie_result;
    private EditText age;
    private String exercise;
    private String gender;
    private TextView extra;
    private TextView lose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        height = (EditText) findViewById(R.id.editHeight);
        weight = (EditText) findViewById(R.id.editWeight);
        age = (EditText) findViewById(R.id.editAge);
        calorie_result = (TextView) findViewById(R.id.calorieStatus);
        extra = (TextView) findViewById(R.id.extraDiet);
        lose = (TextView) findViewById(R.id.loseWeight);

        Spinner dropdown = findViewById(R.id.spinner1);
        String[] activity = new String[]{"No exercise", "Exercise 1-3 times a week",
                "Exercise 4-6 times a week", "Daily exercise"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, activity);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getItemAtPosition(position).toString();
                switch(selected) {
                    case "No exercise":
                        exercise = "No exercise";
                        break;
                    case "Exercise 1-3 times a week":
                        exercise = "Exercise 1-3 times a week";
                        break;
                    case "Exercise 4-6 times a week":
                        exercise = "Exercise 4-6 times a week";
                        break;
                    case "Daily exercise":
                        exercise = "Daily exercise";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.maleDiet:
                if (checked) {
                    gender = "male";
                    break;
                }
            case R.id.femaleDiet:
                if (checked) {
                    gender = "female";
                    break;
                }
        }
    }

    private String show_status(float calorie) {

        String new_cal = String.format("%.2f", calorie);

        String str = "Maintain weight: " + new_cal;

        return str;
    }

    private String show_loss(float calorie) {
        String half_cal = String.format("%.2f", calorie * .9);
        String one_cal = String.format("%.2f", calorie * .8);
        String two_cal = String.format("%.2f", calorie * .61);

        String str = "Lose 0.5 lbs a week: " + half_cal
                + "\nLose 1 lb a week: " + one_cal
                + "\nLose 2 lb a week: " + two_cal;

        return str;
    }

    public void result_calorie(View v) {
        String curr_height = height.getText().toString();
        String curr_weight = weight.getText().toString();
        String curr_age = age.getText().toString();
        String calorie_status = "";
        String loss_status = "";
        float calorie = 0;

        if (curr_height.length() > 0 && curr_height != null && curr_weight.length() > 0 && curr_weight != null &&
        curr_age.length() > 0 && curr_age != null && exercise.length() > 0 && exercise != null
        && gender.length() > 0 && gender != null) {
            float height_float = Float.parseFloat(curr_height);
            float weight_float = Float.parseFloat(curr_weight);
            float age_float = Float.parseFloat(curr_age);
            float bmr;
            float w = 0;
            float h = 0;
            float a = 0;

            if (gender.equals("male")) {
                w = (float) (6.3 * weight_float);
                h = (float) (12.9 * height_float);
                a = (float) (6.8 * age_float);
                bmr = 66 + w + h - a;
                switch (exercise) {
                    case "No exercise":
                        calorie = (float) (bmr * 1.20);
                        break;
                    case "Exercise 1-3 times a week":
                        calorie = (float) (bmr * 1.375);
                        break;
                    case "Exercise 4-6 times a week":
                        calorie = (float) (bmr * 1.55);
                        break;
                    case "Daily exercise":
                        calorie = (float) (bmr * 1.725);
                        break;
                }

            }

            else if (gender.equals("female")) {
                bmr = (float) (655 + (4.3 * weight_float) + (4.7 * height_float) - (4.7 * age_float));
                if (exercise.equals("No exercise")) {
                    calorie = (float) (bmr * 1.20);
                } else if (exercise.equals("Exercise 1-3 times a week")) {
                    calorie = (float) (bmr * 1.375);
                } else if (exercise.equals("Exercise 4-6 times a week")) {
                    calorie = (float) (bmr * 1.55);
                } else if (exercise.equals("Daily exercise")) {
                    calorie = (float) (bmr * 1.725);
                }

            }

            calorie_status = show_status(calorie);
            loss_status = show_loss(calorie);

            calorie_result.setText(calorie_status);
            lose.setText(loss_status);
            extra.setText(R.string.extra);
        }
    }

}