package com.example.dailyup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class BmiGraph extends AppCompatActivity {

    private String savedBMI;
    private int currBMI;
    private TextView bmiData;
    private String bmiCat;
    private ArrayList<Double> bmiArray = new ArrayList<Double>();
    private String value;
    private Button clearButton;
    private String[] bmi_values;

    public static final String SHARED_PREFS = "sharedPrefs";
    //private boolean switchOnOff;

    LineGraphSeries<DataPoint> bmiTimeGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_graph);

        bmiData = (TextView) findViewById(R.id.bmiData);
        clearButton = (Button) findViewById(R.id.clearButton);

        Intent intent = getIntent();
        String savedBMI = intent.getStringExtra("bmi");


        //SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        //savedBMI = sharedPreferences.getString("bmi", "hello");
        //switchOnOff = sharedPreferences.getBoolean("saveSwitch", false);
        //bmiData.setText(savedBMI);
        /**saveSwitch.setChecked(switchOnOff);**/
        /** SharedPreferences sharedPreferences =
         this.getSharedPreferences("com.example.dailyup", Context.MODE_PRIVATE);
         savedBMI = sharedPreferences.getInt("bmi", 0);

         bmiData.setText(savedBMI);**/

        SharedPreferences settings = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        value = settings.getString("bmi", "");

        if (value.length() != 0) {
            String appendValue = value + "\n" + savedBMI;
            editor.putString("bmi", appendValue);
            editor.apply();
            bmiData.setText(appendValue);
            bmi_values = appendValue.split("\\s+");
        }
        else {
            editor.putString("bmi", savedBMI);
            editor.apply();
            bmiData.setText(savedBMI);
            bmi_values = savedBMI.split(" ");
        }

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove("bmi").apply();
                bmiData.setText("");
            }
        });


        Double temp;

        for(int i = 0; i < bmi_values.length; i++) {

            temp = Double.valueOf(bmi_values[i]);
            bmiArray.add(temp);

        }

        /**for(int i = 0; i < bmiArray.size(); i++) {
            bmiCat += (bmiArray.get(i).toString());
            bmiCat += ("\n");
        }

        bmiData.setText(bmiCat);**/

        double x, y;
        x = 0;
        GraphView graph = (GraphView) findViewById(R.id.bmiOverTime);
        bmiTimeGraph = new LineGraphSeries<DataPoint>();
        for(int i = 0; i < bmiArray.size(); i++) {
            y = bmiArray.get(i);
            bmiTimeGraph.appendData(new DataPoint(x, y), true, 500);
            x = x + 1;
        }
        graph.addSeries(bmiTimeGraph);

        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(bmiArray.size() + 1);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(100);

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setXAxisBoundsManual(true);

    }
}