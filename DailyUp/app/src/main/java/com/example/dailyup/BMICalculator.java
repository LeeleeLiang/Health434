package com.example.dailyup;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BMICalculator extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView bmi_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        height = (EditText) findViewById(R.id.editTextHeight);
        weight = (EditText) findViewById(R.id.editTextWeight);
        bmi_result = (TextView) findViewById(R.id.textView6);
    }

    private String show_status(float bmi) {

        String str = "";
        if(Float.compare(bmi, 15f) <= 0) {
            str = bmi + "\nCRITICALLY UNDERWEIGHT";
        }
        else if(Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 19f) <= 0) {
            str = bmi + "\nUNDERWEIGHT";
        }
        else if(Float.compare(bmi, 19f) > 0 && Float.compare(bmi, 24f) <= 0) {
            str = bmi + "\nNORMAL";
        }
        else if(Float.compare(bmi, 24f) > 0 &&Float.compare(bmi, 29f) <= 0) {
            str = bmi + "\nOVERWEIGHT";
        }
        else if(Float.compare(bmi, 29f) > 0 && Float.compare(bmi, 34f) <= 0) {
            str = bmi + "\nOBESE";
        }
        else if(Float.compare(bmi, 34f) > 0) {
            str = bmi + "\nCRITICALLY OBESE";
        }
        else {
            str = "BMI unable to be calculated";
        }
        return str;
    }

    public void result_bmi(View v) {
        String curr_height = height.getText().toString();
        String curr_weight = weight.getText().toString();
        String bmi_status = "";

        if (curr_height.length() > 0 && curr_height != null && curr_weight.length() > 0 && curr_weight != null) {
            float height_float = Float.parseFloat(curr_height);
            float weight_float = Float.parseFloat(curr_weight);

            float bmi = weight_float / (height_float * height_float) * 703;

            bmi_status = show_status(bmi);
            bmi_result.setText(bmi_status);
        }
    }

}
