package com.example.joy.phonevideo.adapter;

import android.content.Context;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joy.phonevideo.R;
import com.example.joy.phonevideo.domain.MediaItem;
import com.example.joy.phonevideo.utils.TimeUtils;

import java.util.List;

/**
 * Created by Joy on 17/7/14.
 */

public class VideoPagerAdapter extends BaseAdapter {
    private List<MediaItem> mediaItems;
    private Context context;
    private TimeUtils timeUtils;

    public VideoPagerAdapter(Context context, List<MediaItem> mediaItems){
        this.context = context;
        this.mediaItems = mediaItems;
        timeUtils = new TimeUtils();
    }

    @Override
    public int getCount() {
        return mediaItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_view_pager,null);
            viewHolder.iv_video = (ImageView) convertView.findViewById(R.id.iv_video_picture);
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_video_name);
            viewHolder.tv_time = (TextView) convertView.findViewById(R.id.tv_video_time);
            viewHolder.tv_size = (TextView) convertView.findViewById(R.id.tv_video_size);
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //根据position得到列表对应位置的数据
        MediaItem mediaItem = mediaItems.get(position);
        viewHolder.tv_name.setText(mediaItem.getName());
        viewHolder.tv_size.setText(Formatter.formatFileSize(context,mediaItem.getSize()));
        viewHolder.tv_time.setText(timeUtils.stringForTime((int) mediaItem.getDuration()));
        return convertView;
    }



static class ViewHolder{
    TextView tv_name;
    TextView tv_time;
    TextView tv_size;
    ImageView iv_video;
    ViewHolder(){

    }
}
}