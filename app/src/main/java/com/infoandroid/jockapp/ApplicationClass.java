package com.infoandroid.jockapp;

import android.app.Application;

public class ApplicationClass extends Application {
    private static ApplicationClass instance;
    public ApplicationClass () {
        super();
    }
    public static ApplicationClass getInstance() {
        return instance;
    }
}
