package com.example.joy.phonevideo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.joy.phonevideo.R;
import com.example.joy.phonevideo.domain.Person;

import org.greenrobot.eventbus.EventBus;

public class EventBusSendActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 跳转到发送页面
     */
    private Button mBtEventbusSend;
    /**
     * 粘性事件跳转到发送页面
     */
    private Button mBtEventbusSendAnd;
    /**
     * 返回到发送页面
     */
    private Button mBtEventbusSendReturn;
    /**
     * 粘性事件返回到发送页面
     */
    private Button mBtEventbusSendReturnAnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_send);
        initView();
    }


    private void initView() {
        mBtEventbusSendReturn = (Button) findViewById(R.id.bt_eventbus_send_return);
        mBtEventbusSendReturn.setOnClickListener(this);
        mBtEventbusSendReturnAnd = (Button) findViewById(R.id.bt_eventbus_send_returnAnd);
        mBtEventbusSendReturnAnd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_eventbus_send_return:
                //4.发送信息
                EventBus.getDefault().post(new Person("hello"));
                break;
            case R.id.bt_eventbus_send_returnAnd:
                break;
        }
    }
}
