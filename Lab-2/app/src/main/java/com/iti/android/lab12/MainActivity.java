package com.iti.android.lab12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String username = intent.getExtras().getString(LoginActivity.USER_NAME_KEY);

        Toast.makeText(getApplicationContext(), "Hello " + username + " from the intent", Toast.LENGTH_LONG).show();
    }

    public void close() {
        this.finish();
    }
}