package com.mvppattern.ListMVP;

import java.util.ArrayList;

/**
 * Created by Vishal on 3/28/2017.
 */

public class ListPresenterImpl implements ListPresenter,ListModal.onListDataListner {

   ListMVPVeiw listMVPVeiw;
   ListModal listModal;

    public ListPresenterImpl(ListMVPVeiw listMVPVeiw) {
        this.listMVPVeiw = listMVPVeiw;
        listModal = new ListModalImpl();
    }

    @Override
    public void showListData(String id, String category) {
        if (listMVPVeiw!=null){
            listModal.listData(id,category,this);
        }

    }

    @Override
    public void Destroyed() {

    }


    @Override
    public void onSuccess(String msg, ArrayList<ListDataBean> listDataBeans) {
        if (listMVPVeiw!=null){
            listMVPVeiw.showSuccessResult("success",listDataBeans);
        }

    }

    @Override
    public void onFailure(String msg) {

    }
}
