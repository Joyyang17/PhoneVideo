package com.example.joy.phonevideo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.joy.phonevideo.R;

/*
* phoneVideo的启动页面
* */

public class SplashActivity extends AppCompatActivity implements View.OnClickListener{

    private final static String TAG = "SplashActivity";

    private Handler handler = new Handler();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //直接 new Handler().postDelayed()有问题,必须自定义一个Handler
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //开始跳转到另一个页面
                startMianActivity();
                Log.i(TAG,"当前线程名称:"+Thread.currentThread().getName());

            }
        },4000);
    }

    //初始化控件
    private void initView(){
        ImageView iv_skip = (ImageView)findViewById(R.id.iv_skip);
        iv_skip.setOnClickListener(this);
    }

    private void startMianActivity() {
        //用Intent进行跳转
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        //关闭当前页面
        finish();
    }


    @Override
    protected void onDestroy() {
        //把所有的消息和任务移除
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG,"当前触摸事件:"+event.getAction());
        startMianActivity();
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_skip:
                break;
        }
    }

    private void start(){

    }
}
