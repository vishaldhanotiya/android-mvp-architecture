package com.mvppattern.ListMVP;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mvppattern.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vishal on 3/28/2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {


    Context context;
    ArrayList<ListDataBean> listDataBeans;



    public ListAdapter(Context context, ArrayList<ListDataBean> listDataBeans) {
        this.context=context;
        this.listDataBeans=listDataBeans;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate( R.layout.place_list_row, parent, false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

   ListDataBean listDataBean=listDataBeans.get(position);

        holder.place_name.setText(listDataBean.getName());
        holder.place_address.setText(listDataBean.getSubject());
    }


    @Override
    public int getItemCount() {
        return listDataBeans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView place_name,place_address;
        ImageView place_image,background_image;

        public MyViewHolder(View itemView) {
            super(itemView);
            place_address=itemView.findViewById(R.id.place_address);
            place_name = itemView.findViewById(R.id.place_name);
            place_image = itemView.findViewById(R.id.place_image);
            // background_image=itemView.findViewById(R.id.background_image);
        }
    }
}