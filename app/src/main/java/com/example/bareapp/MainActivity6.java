package com.example.bareapp;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {

    @SuppressLint("QueryPermissionsNeeded")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        ClipboardManager clipMan = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);

        this.findViewById(R.id.buttonCopy1).setOnClickListener(v -> {
            EditText text = this.findViewById(R.id.editTextCopy1);
            ClipData clipData = ClipData.newPlainText("clipboard", text.getText().toString());
            clipMan.setPrimaryClip(clipData);
            Toast.makeText(this, "text copied", Toast.LENGTH_SHORT).show();
        });

        this.findViewById(R.id.buttonPaste1).setOnClickListener(v -> {
            ClipData primaryClipData = clipMan.getPrimaryClip();
            CharSequence charPaste = primaryClipData.getItemAt(0).getText();
            if (charPaste != null) {
                String textPaste = charPaste.toString();

                EditText text = this.findViewById(R.id.editTextPaste1);
                text.setText(textPaste);

                Toast.makeText(this, "clipboard pasted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No text stored in clipboard"
                        , Toast.LENGTH_SHORT).show();
            }
        });

        this.findViewById(R.id.buttonCopy2).setOnClickListener(v -> {
            EditText text = this.findViewById(R.id.editTextCopy2);

            Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(text.getText().toString()));

            ClipData clipData = ClipData.newIntent("clipboard", intentWeb);
            clipMan.setPrimaryClip(clipData);

            Toast.makeText(this, "web intent copied", Toast.LENGTH_SHORT).show();
        });

        this.findViewById(R.id.buttonPaste2).setOnClickListener(v -> {
            EditText text = this.findViewById(R.id.editTextPaste2);

            ClipData primaryClipData = clipMan.getPrimaryClip();
            Intent intentPaste = primaryClipData.getItemAt(0).getIntent();
            if (intentPaste != null) {
                if (intentPaste.resolveActivity(getPackageManager()) != null) {
                    text.setText(intentPaste.toString());
                    startActivity(intentPaste);
                } else {
                    Toast.makeText(this
                            , "The action stored in clipboard is not supported on this device"
                            , Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "No action intent stored in clipboard"
                        , Toast.LENGTH_SHORT).show();
            }
        });

        this.findViewById(R.id.buttonCopy3).setOnClickListener(v -> {
            RadioGroup radioGroup = this.findViewById(R.id.radioGroup);
            if (radioGroup.getCheckedRadioButtonId() != -1) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                int resId;
                if (radioId == R.id.radioButtonSmile) {
                    resId = R.drawable.smile;
                } else if (radioId == R.id.radioButtonCry) {
                    resId = R.drawable.cry;
                } else {
                    resId = R.drawable.ic_launcher_foreground;
                }

                Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                        "://" + getResources().getResourcePackageName(resId)
                        + '/' + getResources().getResourceTypeName(resId)
                        + '/' + getResources().getResourceEntryName(resId));
                
                ClipData clipData = ClipData.newRawUri("clipboard", imageUri);
                clipMan.setPrimaryClip(clipData);

                Toast.makeText(this, "image copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });

        this.findViewById(R.id.buttonPaste3).setOnClickListener(v -> {
            ClipData primaryClipData = clipMan.getPrimaryClip();
            Uri imageUri = primaryClipData.getItemAt(0).getUri();
            if (imageUri != null) {
                ImageView image = this.findViewById(R.id.imageView);

                image.setImageURI(imageUri);
                Toast.makeText(this, "image pasted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No image stored in clipboard"
                        , Toast.LENGTH_SHORT).show();
            }
        });
    }
}