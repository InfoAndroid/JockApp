package com.infoandroid.jockapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.infoandroid.jockapp.model.JokeModel;
import com.infoandroid.jockapp.model.response.JokeResponse;
import com.infoandroid.jockapp.restClient.ResponseListener;
import com.infoandroid.jockapp.restClient.RestClient;
import com.infoandroid.jockapp.util.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MasterActivity extends AppCompatActivity implements ResponseListener {
    RecyclerView recyclerView;
    private RestClient restClient;
    MyRecyclerViewAdapter adapter;
    private JokeResponse jokeResponse;
    private  ArrayList<JokeModel> jokeModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
        jokeResponse=new JokeResponse();
        restClient = new RestClient(MasterActivity.this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        restClient.callback( MasterActivity.this).forgototpMobileVerify(10);
    }

    private void data() {
           int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new MyRecyclerViewAdapter(this, jokeModels);

        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onSuccessResponce(int apiId, Object responce) {
        JSONObject jsonObject = null;
        jokeModels =new ArrayList<>();
        jokeResponse = (JokeResponse) responce;
        try {
            jsonObject = new JSONObject(responce.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("value");
            jokeModels = new Gson().fromJson(jsonArray.toString(), new TypeToken<List<JokeModel>>(){}.getType());
        } catch (JSONException e) {
            e.printStackTrace();
        }



        data();
    }

    @Override
    public void onFailearResponce(int apiId, String error) {
        Log.d("Data","fffffffffff");
    }
}
