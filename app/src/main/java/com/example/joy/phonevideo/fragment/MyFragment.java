package com.example.joy.phonevideo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joy.phonevideo.base.BasePager;

/**
 * Created by Joy on 17/7/12.
 */

public class MyFragment extends Fragment {
    private BasePager currPager;

    public MyFragment(BasePager pager) {
        this.currPager=pager;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (currPager != null){
            return currPager.rootView;
        }
        return null;


    }
}
