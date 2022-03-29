package com.example.fitboss1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.logging.Level;

public class MainActivity extends AppCompatActivity {

    int Strength =1, level=0, health = 100,UpperLVL=0,LowerLVL=0,CoreLVL=0, EnduranceLVL=0;
    int GainedXp=0;
    //boolean x=





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView TextLevel,TextStrength, TextHealth, TextCore, TextUpper, TextLower,TextEndurance;



        final Button Gainz = findViewById(R.id.Gainz);
        final Button Boss = findViewById(R.id.Boss);
        TextLevel = (TextView)findViewById(R.id.TextLevel);
        TextStrength = (TextView)findViewById(R.id.StrengthValText);
        TextHealth = (TextView)findViewById(R.id.TextHealth);
        TextCore = (TextView)findViewById(R.id.CoreValText);
        TextUpper = (TextView)findViewById(R.id.UpperValText);
        TextLower = (TextView)findViewById(R.id.LowerValText);
        TextEndurance = (TextView)findViewById(R.id.EndurValText);

        if (getIntent().getExtras() !=null) {
            Bundle bundle = getIntent().getExtras();
            UpperLVL = bundle.getInt("Upper");
            LowerLVL = bundle.getInt("Lower");
            CoreLVL = bundle.getInt("Core");
            EnduranceLVL = bundle.getInt("Endurance");
            level= bundle.getInt("LVL");
        }

        Strength = UpperLVL+LowerLVL+CoreLVL+EnduranceLVL;

        TextLevel.setText(Integer.toString(level));
        TextStrength.setText(Integer.toString(Strength));
        TextHealth.setText(Integer.toString(health));
        TextCore.setText(Integer.toString(CoreLVL));
        TextUpper.setText(Integer.toString(UpperLVL));
        TextLower.setText(Integer.toString(LowerLVL));
        TextEndurance.setText(Integer.toString(EnduranceLVL));

        Gainz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoToGainz = new Intent(MainActivity.this, Gainz.class);

                GoToGainz.putExtra("Upper",UpperLVL);
                GoToGainz.putExtra("Lower",LowerLVL);
                GoToGainz.putExtra("Endurance",EnduranceLVL);
                GoToGainz.putExtra("Core",CoreLVL);

                startActivity(GoToGainz);

            }
        });

        Boss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoToBoss = new Intent(MainActivity.this, Boss.class);
                GoToBoss.putExtra("Strength",Strength);
                GoToBoss.putExtra("Level",level);
                startActivity(GoToBoss);

            }
        });
    }








}