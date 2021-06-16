package com.example.bareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .add(R.id.frameLayout, new BlankFragment()).commit();

        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .add(R.id.frameLayout2, new BlankFragment2()).commit();

        this.findViewById(R.id.btnFragOne).setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .replace(R.id.frameLayout, new BlankFragment2()).addToBackStack(null).commit();
        });
    }
}