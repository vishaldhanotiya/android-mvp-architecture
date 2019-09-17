package com.mvppattern.API;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vishal on 3/28/2017.
 */

public class APIClient {

    private static Retrofit retrofit=null;

    public  static Retrofit getClient(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //httpClient.connectTimeout(120, TimeUnit.SECONDS).readTimeout(120, TimeUnit.SECONDS).build();
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(120, TimeUnit.SECONDS).readTimeout(120, TimeUnit.SECONDS).build();
        retrofit=new Retrofit.Builder().baseUrl("http://xxx.com/api/web/index.php/").addConverterFactory(GsonConverterFactory.create())
                .client(client).build();

        return retrofit;
    }
}
