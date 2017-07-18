package com.example.joy.phonevideo.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.joy.phonevideo.R;

/**
 * Created by Joy on 17/7/14.
 */
public class SystemVideoplayer extends AppCompatActivity {

    private final static String TAG = "SystemVideoplayer";

    private VideoView mVvVideoplayer;
    private Uri uri;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_video_player);
        Log.i(TAG, "进入到SystemVideoplayer的onCreate方法");
        initView();
        mVvVideoplayer = (VideoView) findViewById(R.id.vv_videoplayer);
        //播放准备的监听
        mVvVideoplayer.setOnPreparedListener(new MyOnPrepareListener());

        //播放失败的监听
        mVvVideoplayer.setOnErrorListener(new MyOnErrorListener());

        //播放完成的监听
        mVvVideoplayer.setOnCompletionListener(new MyOnCompletionListener());

        uri  = getIntent().getData();
        Log.i(TAG,uri.toString()+"...");

        if (uri != null){
            mVvVideoplayer.setVideoURI(uri);
        }

        //设置控制面板
        mVvVideoplayer.setMediaController(new MediaController(this));
    }

    private void initView() {
    }

    class MyOnPrepareListener implements MediaPlayer.OnPreparedListener{

        //当底层解码准备好的时候
        @Override
        public void onPrepared(MediaPlayer mp) {
            mVvVideoplayer.start();
            Log.i("准备","准备好了");
        }
    }


    class MyOnCompletionListener implements MediaPlayer.OnCompletionListener{


        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText(SystemVideoplayer.this,"播放完成了哦",Toast.LENGTH_SHORT).show();
        }
    }

    class MyOnErrorListener implements MediaPlayer.OnErrorListener{

        //当出错的时候
        @Override
        public boolean onError(MediaPlayer mp, int what, int extra) {
            Toast.makeText(SystemVideoplayer.this,"播放出错了哦",Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}
