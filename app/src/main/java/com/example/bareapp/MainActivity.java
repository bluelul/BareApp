package com.example.bareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = ">>> main ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: ");
        
        Button button1 = this.findViewById(R.id.button1);
        Button button2 = this.findViewById(R.id.button2);
        Button button3 = this.findViewById(R.id.button3);
        Button button4 = this.findViewById(R.id.button4);

        button1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity1.class);
            intent.putExtra("text", "intent");
            MainActivity.this.startActivity(intent);
            overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
        });

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("text", "get phone");
            MainActivity.this.startActivity(intent);
        });

        button3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
            intent.putExtra("text", "layout");
            MainActivity.this.startActivity(intent);
        });

        button4.setOnClickListener(v -> {
            View baseView = this.findViewById(android.R.id.content);
            Snackbar.make(baseView, "snackbar message", Snackbar.LENGTH_LONG)
                    .setAction("BTN", vs -> {
                        Snackbar.make(baseView, "btn clicked", Snackbar.LENGTH_SHORT)
                                .show();
                    })
                    .show();
        });

        this.findViewById(R.id.button5).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity4.class);
            intent.putExtra("text", "watch text");
            MainActivity.this.startActivity(intent);
        });

        this.findViewById(R.id.button6).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity5.class);
            intent.putExtra("text", "scroll view");
            MainActivity.this.startActivity(intent);
        });

        this.findViewById(R.id.button7).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity6.class);
            intent.putExtra("text", "clipboard");
            MainActivity.this.startActivity(intent);
        });
    }

    private static final int BACK_INTERVAL = 2000;
    long mBack = System.currentTimeMillis();

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() < mBack + BACK_INTERVAL) {
            super.onBackPressed();
        }
        else {
            Toast.makeText(MainActivity.this, "Press Back again to exit", Toast.LENGTH_SHORT).show();
            mBack = System.currentTimeMillis();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }
}