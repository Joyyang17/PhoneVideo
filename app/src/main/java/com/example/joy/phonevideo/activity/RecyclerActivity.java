package com.example.joy.phonevideo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.joy.phonevideo.R;
import com.example.joy.phonevideo.adapter.RecyclerAdadpter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private List<String> datas = new ArrayList<>();

    private RecyclerView mRvTest;

    private RecyclerAdadpter mRecyclerAdadpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        initView();
        initData();

        mRecyclerAdadpter = new RecyclerAdadpter(datas);

        mRvTest.setAdapter(mRecyclerAdadpter);

        mRvTest.setLayoutManager(new LinearLayoutManager(this));

        //设置分割线
        //mRvTest.addItemDecoration();
    }

    private void initData() {
        datas.add("好人");
        datas.add("情歌");
        datas.add("美丽之景");
        datas.add("kong");
        datas.add("命硬");
        datas.add("信我");
        datas.add("迟钝");
        datas.add("决战二世祖");


    }

    private void initView() {
        mRvTest = (RecyclerView) findViewById(R.id.rv_test);
    }


}
