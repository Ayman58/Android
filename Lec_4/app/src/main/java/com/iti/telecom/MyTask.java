package com.iti.telecom;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MyTask extends AsyncTask<String, Void, String> {


    @Override
    protected String doInBackground(String... params) {
        String result = null;
        try {
            URL url = new URL(params[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // Check for successful response code or throw error
            conn.setConnectTimeout(5000);
            if (conn.getResponseCode() != 200) {
                throw new IOException(conn.getResponseMessage());
            }


            // Buffer the result into a string
            BufferedReader buffrd = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = buffrd.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString();
            buffrd.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        if (s != null) {
            Gson gson = new Gson();
            MoviesModel response = gson.fromJson(s, MoviesModel.class);
            Log.i("+++++++++",response.getTotal_pages());
        }
    }

}
