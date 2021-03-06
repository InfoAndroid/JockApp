package com.infoandroid.jockapp.util;

import java.util.concurrent.TimeUnit;

/**
 * Created by mukesh on 6/05/2018.
 */

public class Constants {
    public static final String EMPTY = "";
    public static final String API_SUCCESS = "success";

    //Network
    public static final String BASE_URL = "https://api.icndb.com/";
    public static final int HTTP_READ_TIMEOUT = 10000;
    public static final int HTTP_CONNECT_TIMEOUT = 6000;

    //ThreadPool
    public static final int CORE_POOL_SIZE = 10;
    public static final int MAX_POOL_SIZE = 15;
    public static final int KEEP_ALIVE_TIME = 120;
    public static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    //prefrance

    public static final  String NAME_KEY="name";
    public static final  String LAST_NAME_KEY="LastName";


}
