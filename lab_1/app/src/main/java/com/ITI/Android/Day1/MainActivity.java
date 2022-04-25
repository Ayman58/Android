package com.ITI.Android.Day1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d( "debug", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d( "debug", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("debug", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("debug", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("debug", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("debug", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("debug", "onDestroy");
    }
}