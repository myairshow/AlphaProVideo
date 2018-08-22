package cn.telecom.alphaprovideo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.telecom.alphaprovideo.R;
import cn.telecom.alphaprovideo.model.VideoItem;

public class PresenterDetail implements Presenter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new Holder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_detail,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Object obj) {
        Holder holder = (Holder)viewHolder;
        VideoItem item = (VideoItem)obj;

        holder.title.setText(item.getTitle());
        holder.desc.setText(item.getDescription());
        holder.author.setText(item.getAuthor());
    }

    private static class Holder extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView desc;
        private TextView author;

        public Holder(View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
            author = itemView.findViewById(R.id.author);
        }

    }
}
