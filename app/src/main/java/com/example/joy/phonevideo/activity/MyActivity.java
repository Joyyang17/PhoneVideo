package com.example.joy.phonevideo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.joy.phonevideo.R;

public class MyActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 跳转
     */
    private Button mBtOne;
    private RelativeLayout mActivityMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("信息","我是onCreate(A)方法");
        setContentView(R.layout.activity_my);
        initView();
    }

    private void initView() {
        mBtOne = (Button) findViewById(R.id.bt_one);
        mBtOne.setOnClickListener(this);
        mActivityMy = (RelativeLayout) findViewById(R.id.activity_my);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_one:
                Intent intent = new Intent(getApplicationContext(),YouActivity.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    protected void onStart() {
        Log.d("信息","我是onStart(A)方法");
        super.onStart();
    }


    @Override
    protected void onResume() {
        Log.d("信息","我是onResume(A)方法");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("信息","我是onPause(A)方法");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("信息","我是onStop(A)方法");
        super.onStop();
    }


    @Override
    protected void onDestroy() {
        Log.d("信息","我是onDestroy(A)方法");
        super.onDestroy();
    }


    @Override
    protected void onRestart() {
        Log.d("信息","我是onRestart(A)方法");
        super.onRestart();
    }

}

