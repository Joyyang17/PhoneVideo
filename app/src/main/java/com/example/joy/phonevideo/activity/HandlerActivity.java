package com.example.joy.phonevideo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.joy.phonevideo.R;

public class HandlerActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtHandler;
    private static final int MY_TEXT = 1;
    /** 我是按钮 */
    private Button mBtHandler;
    private TextView mTvHandler;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MY_TEXT:
                    mTvHandler.setText("好人");
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        initView();
    }

    private void initView() {
        mEtHandler = (EditText) findViewById(R.id.et_handler);
        mBtHandler = (Button) findViewById(R.id.bt_handler);
        mBtHandler.setOnClickListener(this);
        mTvHandler = (TextView) findViewById(R.id.tv_handler);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_handler:
                Message message = new Message();
                message.what = MY_TEXT;
                handler.sendMessage(message);
                break;
        }
    }
}
