package com.monoremix.basicpushnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.parse.ParseObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseObject object = new ParseObject("Item");
        object.saveInBackground();
    }
}