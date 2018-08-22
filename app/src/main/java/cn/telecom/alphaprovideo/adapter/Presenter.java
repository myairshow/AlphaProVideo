package cn.telecom.alphaprovideo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;


/**
 * Created by airshow on 2018/3/30.
 */
interface Presenter {
    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent);

    void onBindViewHolder(RecyclerView.ViewHolder holder, Object item);
}