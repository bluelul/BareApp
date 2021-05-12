package com.example.bareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {

    private  ClipboardManager clipboardManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        clipboardManager = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);

        this.findViewById(R.id.buttonCopy1).setOnClickListener(v -> {
            EditText textCopy1 = this.findViewById(R.id.editTextCopy1);
            ClipData clipData = ClipData.newPlainText("clipboardx", textCopy1.getText());
            clipboardManager.setPrimaryClip(clipData);
        });

        this.findViewById(R.id.buttonPaste1).setOnClickListener(v -> {
            EditText textPaste1 = this.findViewById(R.id.editTextPaste1);
            ClipData primaryClipData = clipboardManager.getPrimaryClip();
            textPaste1.setText(primaryClipData.getItemAt(0).getText().toString());
        });
    }
}