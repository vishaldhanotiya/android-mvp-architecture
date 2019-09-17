package com.mvppattern.LoginMVP;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.mvppattern.API.APIClient;
import com.mvppattern.API.APIInterface;
import com.mvppattern.API.LoginBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

/**
 * Created by Vishal on 3/28/2017.
 */

public class LoginInterceptorImpl implements LoginInterceptor {

    APIInterface  apiInterface;
    Call<ResponseBody> call;


    @Override
    public void login(String username, String password, final onLoginFinishdListner listener) {

        if (TextUtils.isEmpty(username))
            listener.onUserNameError("Please Enter User Name");
        else if (TextUtils.isEmpty(password))
            listener.onUserPasswordError();
        else {

            checkLoginCredential(username, password,listener);
           /* new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    listener.onSuccess();
                }
            },3000);
*/
        }/*if (username.equals("vishal") && password.equals("12345")) */ /*else {
            listener.onFailure("Invalid credentials");
        }*/

    }

    private void checkLoginCredential(String username,String password,final onLoginFinishdListner listener) {



        LoginBean loginBean=new LoginBean();
        loginBean.setDevice_id("en");
        loginBean.setDevice_type("android");
        loginBean.setCertification_type("certification_type");
        loginBean.setPhone_number(username);
        loginBean.setPassword(password);
        loginBean.setUser_role("driver");
        loginBean.setCode("en");


        apiInterface= APIClient.getClient().create(APIInterface.class);
        call=apiInterface.checkLoginSession("en",loginBean);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String responseRecieved = response.body().string();
                    JSONObject jsonObj = new JSONObject(responseRecieved);

                    boolean success=jsonObj.getBoolean("success");


                    if (success){
                        JSONObject jsonObject=jsonObj.getJSONObject("data");
                        String access_token=jsonObject.getString("access_token");
                        listener.onSuccess();
                    }else{

                        JSONArray jsonArray=jsonObj.getJSONArray("error");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object= (JSONObject) jsonArray.get(i);
                            String message=object.getString("message");

                            listener.onFailure(message);
                        }

                    }


                  //Toast.makeText(LoginInterceptorImpl.this, "", Toast.LENGTH_SHORT).show();
                    // listener.onSuccess();

                } catch (IOException e) {
                    e.printStackTrace();
                    listener.onFailure( "error");
                } catch (JSONException e) {
                    e.printStackTrace();
                    listener.onFailure( "error");
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {


            }
        });


    }
}