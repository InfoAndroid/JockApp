package com.infoandroid.jockapp.restClient;



import com.infoandroid.jockapp.ApplicationClass;
import com.infoandroid.jockapp.util.Util;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.infoandroid.jockapp.util.Constants.BASE_URL;


public class RestService {

    private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response originalResponse = chain.proceed(chain.request());
            /*if (Util.isNetworkAvailable(ApplicationClass.getInstance())) {
                int maxAge = 60; // read from cache for 1 minute
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }*/

            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + 100)
                    .build();
        }
    };
    private static long CONNECTION_TIMEOUT = 600;
    private static String API_URL = BASE_URL;

    public static Rest getService() {
        OkHttpClient client = getOkHttpClient();
        Rest rest = new Retrofit.Builder().baseUrl(API_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create()).build().create(Rest.class);
        return rest;
    }

    private static OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder okClientBuilder = new OkHttpClient.Builder();
        //okClientBuilder.addInterceptor(headerAuthorizationInterceptor);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okClientBuilder.addInterceptor(httpLoggingInterceptor);
        //okClientBuilder.addNetworkInterceptor(new StethoInterceptor());
//        final @Nullable File baseDir = context.getCacheDir();
//        if (baseDir != null) {
//            final File cacheDir = new File(baseDir, “HttpResponseCache”);
//            okClientBuilder.cache(new Cache(cacheDir, HTTP_RESPONSE_DISK_CACHE_MAX_SIZE));
//        }
        okClientBuilder.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        okClientBuilder.readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        okClientBuilder.writeTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);

        okClientBuilder.networkInterceptors().add(REWRITE_CACHE_CONTROL_INTERCEPTOR);

        //setup cache
       /* File httpCacheDirectory = new File(ApplicationClass.getInstance().getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);
*/
        //add cache to the client
      //  okClientBuilder.cache(cache);

        return okClientBuilder.build();
    }
}
