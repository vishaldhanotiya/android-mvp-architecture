package com.mvppattern.ListMVP;

import java.util.ArrayList;

/**
 * Created by Vishal on 3/28/2017.
 */

public interface ListModal {

    interface onListDataListner{
        void onSuccess(String msg, ArrayList<ListDataBean> listDataBeans);
        void onFailure(String msg);
    }

    void listData(String id,String category,onListDataListner listDataListner);
}
