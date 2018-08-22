package cn.telecom.alphaprovideo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cn.telecom.alphaprovideo.R;

/**
 * Created by liuxunlan on 2017/1/11.
 */

public abstract class MagicBaseAdapter extends RecyclerView.Adapter {

    private SparseArray<Presenter> presenterMap = new SparseArray<>();
    protected ArrayList<Object> items = new ArrayList<>();


    public Presenter findPresenter(int position) {
        Object obj = getItem(position);
        if (obj != null) {
            return presenterMap.get(obj.hashCode());
        } else {
            return null;
        }
    }


    public Object getItem(int position) {
        if (position < 0 || position >= items.size()) {
            return null;
        }
        return items.get(position);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Presenter presenter = presenterMap.get(viewType);
        if (presenter != null) {
            return presenter.onCreateViewHolder(parent);
        } else {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_null, parent, false);
            RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(itemView) {
                @Override
                public String toString() {
                    return "warning";
                }
            };
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Object obj = getItem(position);
        if (obj != null) {
            findPresenter((position)).onBindViewHolder(holder, obj);
        }
    }


    public void addItem(Object object, Presenter presenter) {
        items.add(object);
        presenterMap.append(object.hashCode(), presenter);
    }

    public void clearItems() {
        items.clear();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        Object obj = getItem(position);
        if (obj != null)
            return obj.hashCode();
        return 0;
    }
}
