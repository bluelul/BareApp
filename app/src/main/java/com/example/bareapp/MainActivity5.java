package com.example.bareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        UserAccount tom = new UserAccount("tom", "admin");
        UserAccount jerry = new UserAccount("jerry", "user");
        UserAccount donald = new UserAccount("donald", "guest");

        UserAccount[] users = new UserAccount[] {tom, jerry, donald};

        ArrayAdapter<UserAccount> arrayAdapter = new
                ArrayAdapter<>(this, android.R.layout.simple_list_item_1, users);

        String[] strs = new String[20];
        for (int i = 0; i < 20; i++) {
            strs[i] = String.valueOf(i);
        }
        ArrayAdapter<String> aStr;
        aStr = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, strs);
        ListView listView = this.findViewById(R.id.listView);
        listView.setAdapter(aStr);
    }
}