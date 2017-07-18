package com.example.joy.phonevideo.base;

import android.content.Context;
import android.view.View;

/**
 * Created by Joy on 17/7/12.
 * 作用:基类,公开类(子类强制实现此类)
 */

public abstract class BasePager {
    /*
    * 上下文对象
    * */
    public final Context context;

    public View rootView;

    //是否初始化数据的标志
    public boolean isInitData;

   public BasePager(Context context){
        this.context = context;
        rootView = initView();
    }

    public abstract View initView();

    /*
    * 当子页面需要初始化数据,联网请求数据,或者是绑定数据的时候需要重写该方法
    * */
    public void initData(){

    };
}
