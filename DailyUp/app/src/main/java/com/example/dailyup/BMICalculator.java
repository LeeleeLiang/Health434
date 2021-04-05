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
            str = "BMI: " + bmi + "\nCRITICALLY UNDERWEIGHT\n\nRecommendations:\n-Do physical activity for 30 minutes 3 times a week."
            + "\n-Each nutritious meals 3 times a day.\n-See a doctor if lost more than 10 pounds of your body weight in the last year or less";
        }
        else if(Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 19f) <= 0) {
            str = "BMI: " + bmi + "\nUNDERWEIGHT\n\nRecommendations:\n-Eat more frequently\nTry nutrient-rich smoothies"
                    + "\n-exercise a few times a week.";
        }
        else if(Float.compare(bmi, 19f) > 0 && Float.compare(bmi, 24f) <= 0) {
            str = "BMI: " + bmi + "\nNORMAL\n\nRecommendations:\n-Keep doing your normal routine, you're Healthy!";
        }
        else if(Float.compare(bmi, 24f) > 0 &&Float.compare(bmi, 29f) <= 0) {
            str = "BMI: " + bmi + "\nOVERWEIGHT\n\nRecommendations:\n-Do physical activity for 30 minutes 2 times a week."
            + "\n-Eat less junk food.";
        }
        else if(Float.compare(bmi, 29f) > 0 && Float.compare(bmi, 34f) <= 0) {
            str = "BMI: " + bmi + "\nOBESE\n\nRecommendations:\n-Do physical activity for 30 minutes 4 times a week."
                    + "\n-Only eat meat every other day.";
        }
        else if(Float.compare(bmi, 34f) > 0) {
            str = "BMI: " + bmi + "\nCRITICALLY OBESE\n\nRecommendations:\n-Seek medical advice.\n" +
            "-Eat healthier.\n-Take a walk a few times a week.";
        }
        else {
            str = "BMI unable to be calculated";
        }

        str += "\n\nUse our workout planner for more advice on how to get in better shape!";
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
