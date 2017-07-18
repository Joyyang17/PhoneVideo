package com.example.joy.phonevideo.domain;

/**
 * Created by Joy on 17/7/13.
 * 代表一个视频或者是音频
 */

public class MediaItem {

    private String name;
    private String artist;
    private String data;
    private long size;
    private long duration;

    @Override
    public String toString() {
        return "MediaItem{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", data='" + data + '\'' +
                ", size=" + size +
                ", duration=" + duration +
                '}';
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
