package com.example.bareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.TimeInterpolator;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity4 extends AppCompatActivity {

    private boolean isFabExtend = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        TextInputLayout textLayout = this.findViewById(R.id.textLayout1);

        EditText editText = textLayout.getEditText();

        assert editText != null;
        editText.addTextChangedListener(new RealNumberWatcher(editText, ' '));

        EditText text2 = this.findViewById(R.id.editTextTextPersonName2);
        text2.addTextChangedListener(new RealNumberWatcher(text2, ' '));

        if (isFabExtend) fabClick();
        this.findViewById(R.id.fabMain).setOnClickListener(v -> {
            fabClick();
            // todo:
            //  - make bounce transition
            //  - get real width, height of a match-constraint object

        });
    }

    private void fabClick() {
        FloatingActionButton fab1 = this.findViewById(R.id.fab1);
        FloatingActionButton fab2 = this.findViewById(R.id.fab2);
        if (isFabExtend) {
            fab1.animate().translationY(0);
            fab2.animate().translationY(0);
            isFabExtend = false;
        } else {
            fab1.animate().translationY(-getResources().getDimension(R.dimen.fabGap));
            fab2.animate().translationY(-getResources().getDimension(R.dimen.fabGap)*2);
            isFabExtend = true;
        }
    }
}