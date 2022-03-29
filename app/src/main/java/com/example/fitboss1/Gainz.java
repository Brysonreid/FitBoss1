package com.example.fitboss1;


import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Gainz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gainz);

        final EditText minutes = findViewById(R.id.minutesValue);

        final Button confirm = findViewById(R.id.Treasury);

        final Spinner dropDown = findViewById(R.id.spinner1);

        String[] items = new String[]{"High-Intensity Weightlifting", "Running", "Walking", "Yoga","Cycling","Elliptical", "Rower", "Stair Stepper","Hiking","Upper body workout","Core workout"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        dropDown.setAdapter(adapter);


        confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String num = minutes.getText().toString();
                if (num ==null){
                    num="0";
                }
                int value = Integer.valueOf(num);


                String exercise = dropDown.getSelectedItem().toString();
                int CorePoint=0,UpperPoint=0,LowerPoint=0, EndurancePoint=0;
                if (exercise.equals("High-Intensity Weightlifting")) {
                    UpperPoint = value*5;
                } else if (exercise.equals("Running")) {
                    EndurancePoint = value*4;
                } else if (exercise.equals("Walking")) {
                    EndurancePoint = value*1;
                } else if (exercise.equals("Yoga")) {
                    EndurancePoint = value;
                } else if (exercise.equals("Cycling")) {
                    EndurancePoint = value*3;
                }else if (exercise.equals("Elliptical")) {
                    EndurancePoint = value * 2;
                }else if (exercise.equals("Rower")) {
                    UpperPoint = value * 3;
                }else if (exercise.equals("Stair Stepper")) {
                    EndurancePoint = value * 2;
                }else if (exercise.equals("Hiking")) {
                    EndurancePoint = value * 2;
                    LowerPoint = value * 1;
                }else if (exercise.equals("Upper body workout")) {
                    UpperPoint = value * 4;
                }else if (exercise.equals("Lower body workout")) {
                    EndurancePoint = value * 4;
                }else if (exercise.equals("Core workout")) {
                    CorePoint = value * 4;
                }

                Bundle bundle = getIntent().getExtras();
                int UpperLVL= bundle.getInt("Upper");
                int LowerLVL= bundle.getInt("Lower");
                int CoreLVL= bundle.getInt("Core");
                int EnduranceLVL= bundle.getInt("Endurance");

                UpperLVL += UpperPoint;
                LowerLVL += LowerPoint;
                CoreLVL += CorePoint;
                EnduranceLVL += EndurancePoint;


                Intent intent = new Intent(Gainz.this, MainActivity.class);
                intent.putExtra("Upper",UpperLVL);
                intent.putExtra("Lower",LowerLVL);
                intent.putExtra("Endurance",EnduranceLVL);
                intent.putExtra("Core",CoreLVL);

                startActivity(intent);






            }

        });


    }


}


//get the spinner from the xml.
//Spinner dropdown = findViewById(R.id.spinner1);
//create a list of items for the spinner.
//String[] items = new String[]{"High-Intensity Weightlifting", "Running", "Walking", "Cycling", "Yoga"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
//  ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
//dropdown.setAdapter(adapter);
