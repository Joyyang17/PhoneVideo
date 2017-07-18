package com.example.joy.phonevideo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.joy.phonevideo.R;
import com.example.joy.phonevideo.domain.Person;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 跳转到发送页面
     */
    private Button mBtEventbusSend;
    /**
     * 粘性事件跳转到发送页面
     */
    private Button mBtEventbusSendAnd;
    private TextView mTvEventbusReseive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        //1.注册eventBus事件
        EventBus.getDefault().register(this);
        initView();
    }

    private void initView() {
        mBtEventbusSend = (Button) findViewById(R.id.bt_eventbus_send);
        mBtEventbusSend.setOnClickListener(this);
        mBtEventbusSendAnd = (Button) findViewById(R.id.bt_eventbus_sendAnd);
        mBtEventbusSendAnd.setOnClickListener(this);
        mTvEventbusReseive = (TextView) findViewById(R.id.tv_eventbus_reseive);
    }

    //5.接受信息
    @Subscribe(threadMode = ThreadMode.MAIN)
    void receiveData(Person person) {
        mTvEventbusReseive.setText(person.name);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_eventbus_send:
                Intent intent = new Intent(this, EventBusSendActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_eventbus_sendAnd:
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //2.解注册eventBus事件
        EventBus.getDefault().unregister(this);
    }
}
