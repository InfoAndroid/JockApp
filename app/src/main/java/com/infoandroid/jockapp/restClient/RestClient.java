package com.infoandroid.jockapp.restClient;

import android.content.Context;
import android.util.Log;


import com.infoandroid.jockapp.model.JokeModel;
import com.infoandroid.jockapp.model.response.JokeResponse;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

/**
 Created by mukesh on 6/05/2018.
 */
public class RestClient extends BaseRestClient {
    ResponseListener responseListener;
    private Rest api;
    private Object object;

    public RestClient(Context _context) {
        super(_context);
    }

    public RestClient callback(ResponseListener responseListener) {
        this.responseListener = responseListener;
        return this;
    }

    private Rest getApi() {
        if (api == null) {
            api = RestService.getService();
        }
        return api;
    }
    public void forgototpMobileVerify(int count) {
        Call<JokeResponse<ArrayList<JokeModel>>> call = getApi().getJokes(count);

        call.enqueue(new Callback<JokeResponse<ArrayList<JokeModel>>>() {
            @Override
            public void onResponse(Call<JokeResponse<ArrayList<JokeModel>>> call, Response<JokeResponse<ArrayList<JokeModel>>> response) {
                responseListener.onSuccessResponce(1, response.body());
            }

            @Override
            public void onFailure(Call<JokeResponse<ArrayList<JokeModel>>> call, Throwable t) {
                responseListener.onFailearResponce(1, t.getMessage());
            }

        });
    }

 }