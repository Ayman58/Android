package com.iti.android.lab12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button login_btn;
    Button close_btn;
    EditText user;
    EditText pass;
    public static final String USER_NAME_KEY = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        login_btn = findViewById(R.id.lgin_btn);
        close_btn = findViewById(R.id.close_btn);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pass.getText().toString().equals("123")) {
                    if (user.getText().toString().length() == 0) {
                        user.setError("user name cant be empty ");
                    } else {
                        Toast.makeText(LoginActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                        mainActivity();
                    }
                }
                else
                {
                    pass.setError(" wrong password ");
                }
            }
        });
        close_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                close();

            }
        });
    }

    protected void mainActivity() {
        String username = user.getText().toString();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra(USER_NAME_KEY, username);
        startActivity(intent);
    }

    protected void close() {
        this.finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("debug", "onStart");
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