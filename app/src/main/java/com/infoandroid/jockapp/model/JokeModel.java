package com.infoandroid.jockapp.model;

/**
 * Created by mukesh on 6/05/2018.
 */
public class JokeModel {

    public static final String TABLE_NAME = "joke_table";
    public static final String ID_FIELD = "_id";
    public static final String JOKE_FIELD = "joke";

    private Integer id;
    private String joke;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

}
