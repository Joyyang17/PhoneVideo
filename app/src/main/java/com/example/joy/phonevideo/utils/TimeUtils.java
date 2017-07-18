package com.example.joy.phonevideo.utils;

import java.util.Formatter;
import java.util.Locale;

/**
 * Created by Joy on 17/7/14.
 */

public class TimeUtils {
    private StringBuffer mStringBuffer;
    private Formatter mFormatter;
    public TimeUtils(){
        //转换成字符串的时间
        mStringBuffer = new StringBuffer();
        mFormatter = new Formatter(mStringBuffer, Locale.getDefault());
    }
    /*
    * 把毫秒转换成:00.00.00这种形式
    * */
    public  String stringForTime(int timeMs) {
        int totalSeconds = timeMs / 1000;
        int seconds = totalSeconds % 60;
        int minute = (totalSeconds / 60) % 60;
        int hour = totalSeconds / 3600;
        mStringBuffer.setLength(0);
        if (hour > 0) {
            return mFormatter.format("%d:%d:%d", hour, minute, seconds).toString();
        } else {
            return mFormatter.format("%d:%d", minute, seconds).toString();
        }

    }
}
