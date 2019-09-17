package com.mvppattern.ListMVP;

import com.mvppattern.API.APIClient;
import com.mvppattern.API.APIInterface;
import com.mvppattern.API.LoginBean;
import com.mvppattern.LoginMVP.LoginInterceptor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vishal on 3/28/2017.
 */

public class ListModalImpl implements ListModal  {

    APIInterface  apiInterface;
    Call<ResponseBody> call;


    @Override
    public void listData(String id, String category, onListDataListner listDataListner) {

        getVehicleType(listDataListner);

        /*ArrayList<ListDataBean> listDataBeans=new ArrayList<>();

     *//*   ListDataBean listDataBean=new ListDataBean();
        listDataBean.setName("Vishal");
        listDataBean.setName("Vijay");
        listDataBean.setName("Vinay");
        listDataBean.setName("Vivik");
        listDataBean.setName("Vijeet");

        listDataBean.setRollnumber("101");
        listDataBean.setRollnumber("102");
        listDataBean.setRollnumber("103");
        listDataBean.setRollnumber("104");
        listDataBean.setRollnumber("105");

        listDataBean.setSubject("Android");
        listDataBean.setSubject("Java");
        listDataBean.setSubject("PHP");
        listDataBean.setSubject("Angular ");
        listDataBean.setSubject("IOS");*//*

        listDataBeans.add(new ListDataBean("Vishal","101","Android"));
        listDataBeans.add(new ListDataBean("Vijay","102","Java"));
        listDataBeans.add(new ListDataBean("Vinay","103","PHP"));
        listDataBeans.add(new ListDataBean("Vivik","104","Angular"));
        listDataBeans.add(new ListDataBean("Vijeet","105","IOS"));

        listDataBeans.add(new ListDataBean("Vishal","106","Android"));
        listDataBeans.add(new ListDataBean("Vijay","107","Java"));
        listDataBeans.add(new ListDataBean("Vinay","108","PHP"));
        listDataBeans.add(new ListDataBean("Vivik","109","Angular"));
        listDataBeans.add(new ListDataBean("Vijeet","1010","IOS"));

        listDataBeans.add(new ListDataBean("Vishal","101","Android"));
        listDataBeans.add(new ListDataBean("Vijay","102","Java"));
        listDataBeans.add(new ListDataBean("Vinay","103","PHP"));
        listDataBeans.add(new ListDataBean("Vivik","104","Angular"));
        listDataBeans.add(new ListDataBean("Vijeet","105","IOS"));*/



    }










    private void getVehicleType(final ListModal.onListDataListner listener) {



        final ArrayList<ListDataBean> listDataBeans=new ArrayList<>();


        apiInterface= APIClient.getClient().create(APIInterface.class);
        call=apiInterface.getVechicletype();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String responseRecieved = response.body().string();
                    JSONObject jsonObj = new JSONObject(responseRecieved);

                    String success=jsonObj.getString("success");

                    JSONArray  jsonArray=jsonObj.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject= (JSONObject) jsonArray.get(i);
                        String id=jsonObject.getString("id");
                        String name=jsonObject.getString("name");
                        String status=jsonObject.getString("status");
                       // String created_at=jsonObject.getString("created_at");
                        //String updated_at=jsonObject.getString("updated_at");


                     listDataBeans.add(new ListDataBean(id,name,status));

                    }

                    listener.onSuccess("Success",listDataBeans);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {


            }
        });


    }
}
