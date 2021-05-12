package com.example.bareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        TextInputLayout textLayout = this.findViewById(R.id.textLayout1);

        EditText editText = textLayout.getEditText();

        assert editText != null;
        editText.addTextChangedListener(new RealNumberWatcher(editText, ' '));

        EditText text2 = this.findViewById(R.id.editTextTextPersonName2);

    }
}