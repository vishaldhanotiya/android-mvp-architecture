package com.mvppattern.API;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Vishal on 3/28/2017.
 */

public interface APIInterface {


    @POST("login/login")
    Call<ResponseBody> checkLoginSession(@Query("language") String language, @Body LoginBean loginBean);

    @POST("list/type")
    Call<ResponseBody> getVechicletype();
}
