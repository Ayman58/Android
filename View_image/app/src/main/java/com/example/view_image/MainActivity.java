package com.example.view_image;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ProgressBar progress=findViewById(R.id.progress);
    ImageView image=findViewById(R.id.image);
    Button button =findViewById(R.id.button);
    EditText editText = findViewById(R.id.editText);
    String url = editText.getText().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Download(View view) {

        if(isNetworkAvailable())
        {
            Download download=new Download();
            download.execute(url);

        }

        else
        {
            Toast.makeText(getApplicationContext(),"Link is corrupted",Toast.LENGTH_SHORT);
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return ((networkInfo !=null) && (networkInfo.isConnected()));

    }


    public class  Download extends AsyncTask<String , Void , Bitmap >{



        Bitmap bitmap =null;
        Image img;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress.setVisibility(View.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String url = strings[0];
            bitmap = downloadImage(url);
            return bitmap ;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(bitmap);
            progress.setVisibility(View.GONE);
            if (result !=null){
                image.setImageBitmap(result);
            }
        }

        public Bitmap downloadImage(String url) {
            Bitmap bitmap=null;

            try {
                InputStream is =(InputStream) new URL(url).getContent();
                bitmap = BitmapFactory.decodeStream(is);
                is.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }

            return bitmap;
        }
    }
}
