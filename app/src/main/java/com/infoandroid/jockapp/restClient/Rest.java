package com.infoandroid.jockapp.restClient;



import com.infoandroid.jockapp.model.JokeModel;
import com.infoandroid.jockapp.model.response.JokeResponse;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mukesh swami on 20/8/16.
 */
public interface Rest {

    @GET("jokes/random/{count}") Call<JokeResponse<ArrayList<JokeModel>>> getJokes(@Path("count") Integer count);

    @GET("jokes/random/{count}") Call<JokeResponse<ArrayList<JokeModel>>> getJokesWithCustomName(
            @Path("count") Integer count,
            @Query("firstName") String firstName,
            @Query("lastName") String lastName);

    @GET("jokes/{idJoke}") Call<JokeResponse<JokeModel>> getJoke(@Path("idJoke") Integer idJoke);

    @GET("/jokes/count") Call<JokeResponse<Integer>> fetchNumberOfJokes();
}
