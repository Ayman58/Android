package com.iti.telecom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button pressBtn;
    EditText userNameEditText;
    public static final String USER_NAME_KEY = "USERNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("++++++++", "On Create");
        pressBtn = findViewById(R.id.btn_pressed);
        userNameEditText = findViewById(R.id.user_name_edit);

//        pressBtn.setOnClickListener(view ->
//                Toast.makeText(getApplicationContext(),"Btn Clicked",Toast.LENGTH_SHORT).show());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("++++++++", "On Stop");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("++++++++", "On Start");
        Toast.makeText(getApplicationContext(), "App opened", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("++++++++", "On Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("++++++++", "On Pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("++++++++", "On Destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("++++++++", "On Restart");
    }

    public void press(View view) {
//        Toast.makeText(getApplicationContext(),"Btn Clicked",Toast.LENGTH_SHORT).show();
        String s = userNameEditText.getText().toString();
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

//        Bundle bundle = new Bundle();
//        bundle.putString(USER_NAME_KEY, s);
//        intent.putExtras(bundle);

        intent.putExtra(USER_NAME_KEY, s);

        startActivity(intent);

    }
}