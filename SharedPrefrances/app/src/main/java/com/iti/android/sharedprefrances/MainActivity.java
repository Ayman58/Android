package com.iti.android.sharedprefrances;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    public static final String SP_NAME = "SP";
    public static final String SP_KEY = "KEY";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button saveBtn = (Button) findViewById(R.id.button);
        Button loadBtn = (Button) findViewById(R.id.button2);
        editText = findViewById(R.id.editText);
        sharedPreferences = getSharedPreferences(SP_NAME, MODE_PRIVATE);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSP(v);
            }
        });

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSP(v);
            }
        });

    }

    public void saveSP(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SP_KEY, editText.getText().toString());
        editor.commit();
        editText.setText("");
    }

    public void loadSP(View view) {
        String s = sharedPreferences.getString(SP_KEY, "No Data Inserted");
        editText.setText(s);
    }
}