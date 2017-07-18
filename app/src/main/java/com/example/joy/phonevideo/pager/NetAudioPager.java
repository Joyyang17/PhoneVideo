package com.example.joy.phonevideo.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.joy.phonevideo.base.BasePager;

/**
 * Created by Joy on 17/7/12.
 */

public class NetAudioPager extends BasePager {
    private TextView textView;
    public NetAudioPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        textView = new TextView(context);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);

        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        textView.setText("这是网络音频页面的加载数据的方法");
    }
}
