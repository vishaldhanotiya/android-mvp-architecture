package com.mvppattern.ListMVP;

import java.util.ArrayList;

/**
 * Created by Vishal on 3/28/2017.
 */

public interface ListMVPVeiw  {

    void showLoading();
    void hideLoading();
    void showError(String msg);
    void showSuccessResult(String msg, ArrayList<ListDataBean> listDataBeans);
}
