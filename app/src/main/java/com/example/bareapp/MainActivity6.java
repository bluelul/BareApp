package com.example.bareapp;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {

    private  ClipboardManager clipboardManager;
    private Camera mCamera;
    @SuppressLint("QueryPermissionsNeeded")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        clipboardManager = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);

        this.findViewById(R.id.buttonCopy1).setOnClickListener(v -> {
            EditText textCopy1 = this.findViewById(R.id.editTextCopy1);
            ClipData clipData = ClipData.newPlainText("clipboard", textCopy1.getText());
            clipboardManager.setPrimaryClip(clipData);
        });

        this.findViewById(R.id.buttonPaste1).setOnClickListener(v -> {
            EditText textPaste1 = this.findViewById(R.id.editTextPaste1);
            ClipData primaryClipData = clipboardManager.getPrimaryClip();
            textPaste1.setText(primaryClipData.getItemAt(0).getText().toString());
        });

        this.findViewById(R.id.buttonCopy2).setOnClickListener(v -> {
            Uri uri = Uri.parse("mailto:" + "bluelul.email@gmail.com");
            Intent intentMail = new Intent(Intent.ACTION_SENDTO, uri);
//            intentSms.putExtra("sms_body", "sms content");
            if (intentMail.resolveActivity(getPackageManager()) != null) {
                startActivity(intentMail);
            } else {
                Toast.makeText(this, "SMS texting is not supported on this device"
                        , Toast.LENGTH_SHORT).show();
            }
        });
    }
}