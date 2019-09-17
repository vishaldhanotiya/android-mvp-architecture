package com.mvppattern.ListMVP;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.mvppattern.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vishal on 3/28/2017.
 */

public class ListViewActivity extends Activity implements ListMVPVeiw{
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    ListPresenter listPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ButterKnife.bind(this);

        GridLayoutManager linearLayout = new GridLayoutManager(ListViewActivity.this, 1);
        recycler_view.setLayoutManager(linearLayout);

        listPresenter=new ListPresenterImpl(ListViewActivity.this);
        listPresenter.showListData("1","test");
    }



    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showSuccessResult(String msg, ArrayList<ListDataBean> listDataBeans) {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        ListAdapter listAdapter = new ListAdapter(ListViewActivity.this, listDataBeans);
        recycler_view.setAdapter(listAdapter);

    }
}
