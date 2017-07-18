package com.example.joy.phonevideo.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.joy.phonevideo.R;
import com.example.joy.phonevideo.base.BasePager;
import com.example.joy.phonevideo.fragment.MyFragment;
import com.example.joy.phonevideo.pager.AudioPager;
import com.example.joy.phonevideo.pager.NetAudioPager;
import com.example.joy.phonevideo.pager.NetVideoPager;
import com.example.joy.phonevideo.pager.VideoPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private FrameLayout mFlMainContent;
    private RadioGroup mRgBottomTag;

    private int mPosition;

    private List<BasePager> mBasePagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        mRgBottomTag.check(R.id.rb_local_video);

    }

    private void initView() {
        mFlMainContent = (FrameLayout) findViewById(R.id.fl_main_content);
        mRgBottomTag = (RadioGroup) findViewById(R.id.rg_bottom_tag);
        mBasePagers = new ArrayList<BasePager>();
        mBasePagers.add(new VideoPager(this)); //0
        mBasePagers.add(new AudioPager(this)); //1
        mBasePagers.add(new NetVideoPager(this)); //2
        mBasePagers.add(new NetAudioPager(this)); //3

        mRgBottomTag.setOnCheckedChangeListener(new MysetOnCheckedChangeListener());

    }


    class MysetOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {


        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_local_audio:
                    mPosition = 1;
                    break;
                case R.id.rb_net_video:
                    mPosition = 2;
                    break;
                case R.id.rb_net_audio:
                    mPosition = 3;
                    break;
                default:
                    mPosition = 0;
                    break;
            }
            setFragment();
        }
    }

    /*
    * 把页面添加进fragment
    * */
    private void setFragment() {
        //设置fragment管理器
        FragmentManager manager = getSupportFragmentManager();
        //开启事务
        FragmentTransaction beginTransaction = manager.beginTransaction();
        //替换页面
        beginTransaction.replace(R.id.fl_main_content, new MyFragment(getBasePager()));
        //提交事务
        beginTransaction.commit();
    }

    private BasePager getBasePager() {
        //获取ArrayList
        BasePager basePager = mBasePagers.get(mPosition);
        //屏蔽多次初始化数据(isInitData)
        if (mBasePagers != null && !basePager.isInitData) {
            basePager.initData(); //联网请求或者绑定数据
            basePager.isInitData = true;
        }
        return basePager;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
