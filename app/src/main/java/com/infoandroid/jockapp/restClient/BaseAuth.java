package com.infoandroid.jockapp.restClient;

import android.util.Base64;

/**
 * Created by mukesh on 6/05/2018.
 */
public class BaseAuth {
    public static String basic(String username, String password) {
        String basicAuth = "Basic " +
                Base64.encodeToString(String.format("%s:%s", username, password)
                                .getBytes(),
                        Base64.NO_WRAP);
        return basicAuth;
    }
}
