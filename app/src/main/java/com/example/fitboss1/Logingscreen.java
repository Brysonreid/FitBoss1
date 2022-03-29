package com.example.fitboss1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Logingscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logingscreen);
        // load the landing page for 5 seconds then redirect into the MainActivity
        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                try {
                    sleep(3000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent primIntent = new Intent(Logingscreen.this, MainActivity.class); // BRYSON replace
                    startActivity(primIntent);                                                              // MainActivity
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}