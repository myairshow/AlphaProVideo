package cn.telecom.alphaprovideo.adapter;

import java.util.ArrayList;

import cn.telecom.alphaprovideo.model.VideoItem;
import cn.telecom.alphaprovideo.model.VideoList;

public class DetailAdapter extends MagicBaseAdapter {

    private PresenterDetail presenterDetail;
    private PresenterRecommend presenterRecommend;

    public DetailAdapter() {
        presenterDetail = new PresenterDetail();
        presenterRecommend = new PresenterRecommend();
    }

    public void putItem(VideoItem item) {
        super.clearItems();
        addItem(item, presenterDetail);

        ArrayList<VideoItem> list = VideoList.getInstance().getItems();
        int index = list.indexOf(item);
        for (int i = 0; i < 4; i++) {
            addItem(list.get((index + i + 1) % list.size()), presenterRecommend);
        }

        notifyDataSetChanged();
    }

}
