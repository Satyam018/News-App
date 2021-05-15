package com.example.newsapp;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.content.ContentValues.TAG;

public class json extends Thread {
    String link="https://gnews.io/api/v4/search?q=example&token=75f75f2638c880939a88e0523f5dc97d";
    String datas;
    jsonparse j1;

    json(jsonparse j1){
        this.j1=j1;
    }

    @Override
    public void run() {
        try {
            URL url=new URL(link);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.connect();
            BufferedReader bf=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String data =bf.readLine();
            this.datas=data;
            j1.setdataobtained(this.datas);

            Log.i(TAG, "run: "+datas);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
