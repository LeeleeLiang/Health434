package com.example.dailyup;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BMICalculator extends AppCompatActivity {

    private EditText feet;
    private EditText inches;
    private EditText weight;
    private TextView bmi_result;
    private TextView recommend;
    private TextView extra;
    private Button saveButton;
    private Button openButton;
    private float savedBMI;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String BMI = "bmi";
    public static boolean valueHere = false;

    private boolean switchOnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_result);

        feet = (EditText) findViewById(R.id.editTextHeight);
        inches = (EditText) findViewById(R.id.editTextHeight2);
        weight = (EditText) findViewById(R.id.editTextWeight);
        bmi_result = (TextView) findViewById(R.id.textView6);
        recommend = (TextView) findViewById(R.id.recBMI);
        extra = (TextView) findViewById(R.id.extra);
        saveButton = (Button) findViewById(R.id.saveButton);
        openButton = (Button) findViewById(R.id.openGraph);
        //saveSwitch = (Switch) findViewById(R.id.saveSwitch);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueHere = true;
                openGraph();
            }
        });

        openButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                valueHere = false;
                openGraph();
            }
        });
    }

    public void openGraph(){
        Intent intent = new Intent(getApplicationContext(), BmiGraph.class);
        intent.putExtra("bmi", String.valueOf(savedBMI));
        startActivity(intent);
    }

    /**public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        editor.putString("bmi", bmi_result.getText().toString());
       // editor.putBoolean("saveSwitch", saveSwitch.isChecked());

        editor.apply();

        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();


       /** SharedPreferences sharedPreferences =
                this.getSharedPreferences("com.example.dailyup", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        int temp_bmi = Integer.parseInt(bmi_result.getText().toString());
        editor.putInt(BMI, temp_bmi);
        editor.commit();

        editor.apply();
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT);
    } **/

    private String show_rec(float bmi) {

        String str = "";

        if(Float.compare(bmi, 15f) <= 0) {
            str = "Recommendations:\n-Do physical activity for 30 minutes 3 times a week."
                    + "\n-Each nutritious meals 3 times a day.\n-See a doctor if lost more than 10 pounds of your body weight in the last year or less";
        }
        else if(Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 18.5f) <= 0) {
            str = "Recommendations:\n-Eat more frequently\nTry nutrient-rich smoothies"
                    + "\n-Exercise a few times a week.";
        }
        else if(Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 24f) <= 0) {
            str = "Recommendations:\n-Keep doing your normal routine, you're Healthy!";
        }
        else if(Float.compare(bmi, 24f) > 0 &&Float.compare(bmi, 29f) <= 0) {
            str = "Recommendations:\n-Do physical activity for 30 minutes 2 times a week."
                    + "\n-Eat less junk food.";
        }
        else if(Float.compare(bmi, 29f) > 0 && Float.compare(bmi, 34f) <= 0) {
            str = "Recommendations:\n-Do physical activity for 30 minutes 4 times a week."
                    + "\n-Only eat meat every other day.";
        }
        else if(Float.compare(bmi, 34f) > 0) {
            str = "Recommendations:\n-Seek medical advice.\n" +
                    "-Eat healthier.\n-Take a walk a few times a week.";
        }

        return str;

    }

    private String show_status(float bmi) {

        String str = "";
        if(Float.compare(bmi, 15f) <= 0) {
            str = "BMI: " + bmi + "\nCRITICALLY UNDERWEIGHT";
        }
        else if(Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 19f) <= 0) {
            str = "BMI: " + bmi + "\nUNDERWEIGHT";
        }
        else if(Float.compare(bmi, 19f) > 0 && Float.compare(bmi, 24f) <= 0) {
            str = "BMI: " + bmi + "\nNORMAL";
        }
        else if(Float.compare(bmi, 24f) > 0 &&Float.compare(bmi, 29f) <= 0) {
            str = "BMI: " + bmi + "\nOVERWEIGHT";
        }
        else if(Float.compare(bmi, 29f) > 0 && Float.compare(bmi, 34f) <= 0) {
            str = "BMI: " + bmi + "\nOBESE";
        }
        else if(Float.compare(bmi, 34f) > 0) {
            str = "BMI: " + bmi + "\nCRITICALLY OBESE";
        }
        else {
            str = "BMI unable to be calculated";
        }

        return str;

    }

    public void result_bmi(View v) {
        reveal();
        String curr_feet = feet.getText().toString();
        String curr_inches = inches.getText().toString();
        String curr_weight = weight.getText().toString();
        String bmi_status = "";
        String rec_status = "";

        if (curr_feet.length() > 0 && curr_feet != null && curr_weight.length() > 0 && curr_weight != null
        && curr_inches.length() > 0 && curr_inches != null) {
            float feet_float = Float.parseFloat(curr_feet);
            float inches_float = Float.parseFloat(curr_inches);
            float weight_float = Float.parseFloat(curr_weight);

            float height_float = (feet_float * 12) + inches_float;

            float bmi = weight_float / (height_float * height_float) * 703;

            bmi_status = show_status(bmi);
            rec_status = show_rec(bmi);

            savedBMI = bmi;

            bmi_result.setText(bmi_status);
            recommend.setText(rec_status);
            extra.setText(R.string.extra);

        }
    }

    public void reveal() {
        // previously visible view
        final View myView = findViewById(R.id.chart);

            // get the center for the clipping circle
            int cx = myView.getWidth() / 2;
            int cy = myView.getHeight() / 2;

            // get the initial radius for the clipping circle
            float initialRadius = (float) Math.hypot(cx, cy);

            // create the animation (the final radius is zero)
            Animator anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, initialRadius, 0f);

            // make the view invisible when the animation is done
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    myView.setVisibility(View.INVISIBLE);
                }
            });

            // start the animation
            anim.start();
    }

}
