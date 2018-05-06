package com.infoandroid.jockapp.restClient;

/**
 *Created by mukesh on 6/05/2018.
 */
public interface ResponseListener {

    void onSuccessResponce(int apiId, Object responce);

    void onFailearResponce(int apiId, String error);
}
