package com.example.bareapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity9 extends AppCompatActivity {

    BlankFragment frag1 = new BlankFragment();
    BlankFragment2 frag2 = new BlankFragment2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        adaptOrient(getResources().getConfiguration());

        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .add(R.id.frameLayout, frag1).commit();

        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .add(R.id.frameLayout2, frag2).commit();

        this.findViewById(R.id.btnFragOne).setOnClickListener(v -> {

        });

        this.findViewById(R.id.btnFragOne).setOnClickListener(v -> {

        });

        this.findViewById(R.id.btnFragThree).setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .replace(R.id.frameLayout, new BlankFragment2()).addToBackStack(null).commit();
        });
    }

    void showText(String text) {
        frag2.showText(text);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        adaptOrient(newConfig);
    }

    private void adaptOrient(@NonNull Configuration config) {
        LinearLayout layoutBtn = findViewById(R.id.linearLayoutBtn);
        LinearLayout layoutFrame = findViewById(R.id.linearLayoutFrame);
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            layoutBtn.setOrientation(LinearLayout.VERTICAL);
            layoutFrame.setOrientation(LinearLayout.HORIZONTAL);
        } else {
            layoutBtn.setOrientation(LinearLayout.HORIZONTAL);
            layoutFrame.setOrientation(LinearLayout.VERTICAL);
        }
    }
}