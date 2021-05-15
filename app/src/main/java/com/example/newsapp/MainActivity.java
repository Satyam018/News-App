package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements jsonparse{
    RecyclerView recyclerView;
    ArrayList<setdata> setdatas;
    adapter adapt;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        json j=new json(MainActivity.this);
        j.start();
        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setdatas=new ArrayList<>();


    }

    @Override
    public void setdataobtained(String data) {
        Log.e(TAG, "run: "+data );
        try {
            jsonparser(data);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void jsonparser(String data1)throws JSONException {

        JSONObject jsonObject=new JSONObject(data1);
        Log.e(TAG, "jsonparser: "+jsonObject );

        JSONArray news=jsonObject.getJSONArray("articles");

        for(int i=0;i<news.length();i++){
            JSONObject info=news.getJSONObject(i);
            String heading=info.getString("title");
            String infourl=info.getString("url");
            String imgurl=info.getString("image");
            setdata s1=new setdata(imgurl,infourl,heading);
            Log.e(TAG, "jsonparser: "+heading);
            setdatas.add(s1);


        }
        adapt=new adapter(setdatas,getApplicationContext());
        recyclerView.setAdapter(adapt);

    }


}