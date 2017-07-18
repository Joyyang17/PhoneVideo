package com.example.joy.phonevideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.joy.phonevideo.R;


/**
 * Created by Joy on 17/7/13.
 */

public class TitleBar extends RelativeLayout implements View.OnClickListener {

    private View tv_search;
    private View tv_game;
    private View iv_history;

    /*
    *在代码中实例化该类的时候,使用该方法
    * */
    public TitleBar(Context context) {
        this(context,null);
    }

    /*
    * 当在布局文件使用该类的时候,使用该方法
    * */
    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    /*
    * 当需要设计样式的时候,使用该方法
    * */
    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //设置子控件的点击事件
        tv_search = getChildAt(0);
       /* tv_game = getChildAt(2);
        iv_history = getChildAt(3);
*/
        //设置点击事件
        tv_search.setOnClickListener(this);
       /* tv_game.setOnClickListener(this);*/
      /*  iv_history.setOnClickListener(this);*/

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.tv_search:
                Toast.makeText(getContext(),"点击了搜索框",Toast.LENGTH_SHORT).show();
                Log.i("信息","被点击了");
                break;
          /*  case  R.id.tv_game:
                Toast.makeText(getContext(),"点击了游戏按钮",Toast.LENGTH_SHORT).show();
                break;*/
            /*case  R.id.iv_history:
                Toast.makeText(getContext(),"点击了历史按钮",Toast.LENGTH_SHORT).show();
                break;*/
        }
    }


}
