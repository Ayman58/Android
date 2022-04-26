package com.iti.telecom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SPActivity extends AppCompatActivity {
    EditText editText;
    private final String USER_NAME_KEY = "USER_NAME_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spactivity);
        editText = findViewById(R.id.editTextUserName);
    }

    public void saveSP(View view) {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_NAME_KEY, editText.getText().toString());
        editor.apply();
        editText.setText("");
    }

    public void loadSP(View view) {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String s = sharedPreferences.getString(USER_NAME_KEY, "No Value Found");
        editText.setText(s);
    }
}