package com.example.joy.phonevideo.pager;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joy.phonevideo.R;
import com.example.joy.phonevideo.activity.SystemVideoplayer;
import com.example.joy.phonevideo.adapter.VideoPagerAdapter;
import com.example.joy.phonevideo.base.BasePager;
import com.example.joy.phonevideo.domain.MediaItem;
import com.example.joy.phonevideo.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joy on 17/7/12.
 */

public class VideoPager extends BasePager {

    private final static String TAG = "VideoPager";

    private List<MediaItem> mediaItems;
    private ListView lv_localvideo;
    private TextView tv_noting;
    private ProgressBar pb_loading;
    private TimeUtils timeUtils;
    private VideoPagerAdapter videoPagerAdapter;

    public VideoPager(Context context) {
        super(context);
        timeUtils = new TimeUtils();
    }

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.main_localvideo, null);
        lv_localvideo = (ListView) view.findViewById(R.id.lv_localVideo);
        tv_noting = (TextView) view.findViewById(R.id.tv_localvideo_noting);
        pb_loading = (ProgressBar) view.findViewById(R.id.pb_localvideo_loading);
        return view;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mediaItems != null && mediaItems.size() > 0) {
                //有数据
                //设置适配器
                videoPagerAdapter = new VideoPagerAdapter(context,mediaItems);
                lv_localvideo.setAdapter(videoPagerAdapter);
                lv_localvideo.setOnItemClickListener(new MyViewPagerListViewItemListener());
                //把文本隐藏
                tv_noting.setVisibility(View.GONE);
            }else {
                //没有数据
                //文本显示
                tv_noting.setVisibility(View.VISIBLE);

            }

            //progressBar隐藏
            pb_loading.setVisibility(View.GONE);
        }
    };

    @Override
    public void initData() {
        super.initData();
        Log.i("信息", "本地视频的数据被初始化了");
        getDataFromLocal();
    }

    /*
    * 1.从本地sdcard得到数据
    * 2.遍历sdcard,后缀名
    * 3.从内容提供者里面获取视频
    * 4.如果是6.0的系统,需要动态读取权限
    * */
    public void getDataFromLocal() {
        //这里需要new一个线程
        new Thread() {
            @Override
            public void run() {
                super.run();
                mediaItems = new ArrayList<MediaItem>();
                ContentResolver cr = context.getContentResolver();
                Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                String[] objs = {
                        MediaStore.Video.Media.DISPLAY_NAME,//视频文件在sdcard中的名称
                        MediaStore.Video.Media.DURATION,//视频总时长
                        MediaStore.Video.Media.SIZE,//视频的文件大小
                        MediaStore.Video.Media.DATA,//视频的绝对路径
                        MediaStore.Video.Media.ARTIST,//歌曲的演唱者
                };
                Cursor cursor = cr.query(uri, objs, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {

                        MediaItem mItem = new MediaItem();

                        mediaItems.add(mItem);//后面的还是会添加

                        String name = cursor.getString(0);//视频的名称
                        mItem.setName(name);
                        long duration = cursor.getLong(1);//视频的总时长
                        mItem.setDuration(duration);
                        long size = cursor.getLong(2);//视频的文件大小
                        mItem.setSize(size);
                        String path = cursor.getString(3);//视频的路径
                        mItem.setData(path);
                        String artist = cursor.getString(4);//艺术家
                        mItem.setArtist(artist);
                    }
                    //释放
                    cursor.close();
                }

                //发消息
                handler.sendEmptyMessage(10);


            }
        }.start();
    }


    /*
    * 监听事件
    * */
    class MyViewPagerListViewItemListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            MediaItem mediaItem = mediaItems.get(position);
            Log.i(TAG,mediaItem.toString());
            Toast.makeText(context,mediaItem.toString(),Toast.LENGTH_SHORT).show();

            //1.调用系统能播放的工具类(隐式intent)
            /*Intent intent = new Intent();
            intent.setDataAndType(Uri.parse(mediaItem.getData()),"video*//*");
            context.startActivity(intent);*/

            //2,调用自己编写的播放器
            Intent intent = new Intent(context,SystemVideoplayer.class);
            intent.setDataAndType(Uri.parse(mediaItem.getData()),"video/*");
            context.startActivity(intent);





        }
    }


}
