package cn.telecom.alphaprovideo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import cn.telecom.alphaprovideo.R;
import cn.telecom.alphaprovideo.model.VideoItem;
import cn.telecom.alphaprovideo.ui.DetailActivity;

public class PresenterRecommend implements Presenter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new Holder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recommend, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Object obj) {
        Holder holder = (Holder) viewHolder;
        final VideoItem item = (VideoItem) obj;

        holder.title.setText(item.getTitle());
        holder.desc.setText(item.getDescription());
        Glide.with(holder.cover).asBitmap().load(item.getCover()).into(holder.cover);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailActivity.open(v.getContext(), item.getId());
            }
        });
    }

    private static class Holder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView desc;
        private ImageView cover;

        public Holder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
            cover = itemView.findViewById(R.id.cover);
        }

    }
}
