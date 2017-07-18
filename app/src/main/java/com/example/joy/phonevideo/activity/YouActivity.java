package com.example.joy.phonevideo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.joy.phonevideo.R;

public class YouActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("信息","我是onCreate(B)方法");
        setContentView(R.layout.activity_you);
    }


    @Override
    protected void onStart() {
        Log.d("信息","我是onStart(B)方法");
        super.onStart();
    }


    @Override
    protected void onResume() {
        Log.d("信息","我是onResume(B)方法");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("信息","我是onPause(B)方法");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("信息","我是onStop(B)方法");
        super.onStop();
    }


    @Override
    protected void onDestroy() {
        Log.d("信息","我是onDestroy(B)方法");
        super.onDestroy();
    }


    @Override
    protected void onRestart() {
        Log.d("信息","我是onRestart(B)方法");
        super.onRestart();
    }
}
