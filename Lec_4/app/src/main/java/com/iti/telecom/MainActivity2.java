package com.iti.telecom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("++++++++", "On Create 2");
//        Intent intent = getIntent();
//        Bundle bundle=intent.getExtras();
//       String s=bundle.getString(MainActivity.USER_NAME_KEY);
//       Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("++++++++", "On Stop 2");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("++++++++", "On Start 2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("++++++++", "On Resume 2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("++++++++", "On Pause 2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("++++++++", "On Destroy 2");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("++++++++", "On Restart 2");
    }

    public void connect(View view) {
      //  new MyTask().execute("http://api.themoviedb.org/3/movie/top_rated?api_key=3c3d662f3dfecdd191da7642c1b1e2af");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieService service = retrofit.create(MovieService.class);
        Call<MoviesModel> call = service.getMovieModel();
        call.enqueue(new Callback<MoviesModel>() {
            @Override
            public void onResponse(Call<MoviesModel> call, Response<MoviesModel> response) {
                if (response.isSuccessful()) {
                    Log.i("+++++++++",response.body().getTotal_pages());
                }
            }

            @Override
            public void onFailure(Call<MoviesModel> call, Throwable t) {

            }
        });

    }
}