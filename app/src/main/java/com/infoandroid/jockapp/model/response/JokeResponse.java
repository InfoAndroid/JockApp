package com.infoandroid.jockapp.model.response;

/**
 * Created by mukesh on 6/05/2018.
 */
public class JokeResponse<T> {

    private String type;
    private T value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
